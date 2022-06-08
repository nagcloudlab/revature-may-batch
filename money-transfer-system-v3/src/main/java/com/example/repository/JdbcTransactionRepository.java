package com.example.repository;

import com.example.datasource.SQLConnectionFactory;
import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TxnType;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTransactionRepository implements TransactionRepository {

    private static final Logger LOG = Logger.getLogger("mts"); // singleton


    public void save(Transaction transaction) {
        LOG.info("saving new transaction");
        try (Connection connection = SQLConnectionFactory.getConnection();) {
            String sql = "insert into transactions(txn_amount,txn_date_time,txn_type,acc_number) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, transaction.getAmount());
            ps.setTimestamp(2, Timestamp.valueOf(transaction.getLocalDateTime()));
            ps.setString(3, transaction.getType().toString());
            ps.setString(4, transaction.getAccount().getNumber());
            int rows = ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("error saving transactions: ");
            e.printStackTrace();
        }
    }

    public List<Transaction> findAll() {
        LOG.info("finding all transactions");
        List<Transaction> transactionList = new ArrayList<>();
        try (Connection connection = SQLConnectionFactory.getConnection();) {
            String sql = "select * from transactions";
            Statement ps = connection.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("txn_id"));
                transaction.setAmount(rs.getDouble("txn_amount"));
                transaction.setType(TxnType.valueOf(rs.getString("txn_type")));
                transaction.setAccount(new Account(rs.getString("acc_number"), 0.0));
                transactionList.add(transaction);
            }
        } catch (SQLException e) {
            LOG.error("error saving transactions: ");
            e.printStackTrace();
        }
        return transactionList;
    }

}
