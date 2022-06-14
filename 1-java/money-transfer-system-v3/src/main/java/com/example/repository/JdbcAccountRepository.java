package com.example.repository;

import com.example.datasource.SQLConnectionFactory;
import com.example.entity.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcAccountRepository implements AccountRepository {

    private static final Logger LOG = Logger.getLogger("mts"); // singleton

    public Optional<Account> findById(String number) {
        LOG.info("loading account: " + number);
        try (Connection connection = SQLConnectionFactory.getConnection();) {
            String sql = "select * from accounts where acc_number=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setNumber(rs.getString("acc_number"));
                account.setBalance(rs.getDouble("acc_balance"));
                return Optional.of(account);
            }
        } catch (SQLException e) {
            LOG.error("error loading account: " + number);
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void update(Account account) {
        LOG.info("updating account: " + account.getNumber());
        try (Connection connection = SQLConnectionFactory.getConnection();) {
            String sql = "update accounts set acc_balance=? where acc_number=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, account.getBalance());
            ps.setString(2, account.getNumber());
            int rows = ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("error updating account: " + account.getNumber());
            e.printStackTrace();
        }
    }


}
