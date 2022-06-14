package com.example.repository;

import com.example.datasource.SQLConnectionFactory;
import com.example.model.Account;
import org.apache.log4j.Logger;
import org.postgresql.Driver;

import java.sql.*;
import java.util.Optional;

public class JdbcAccountRepository implements AccountRepository {

    private static final Logger LOGGER = Logger.getLogger("mts");

    public Optional<Account> loadAccount(String number) {
        Connection connection = null;
        try {
            connection = SQLConnectionFactory.getConnection();
            // step-3: jdbc-statement with SQL query
            String sql = "select * from accounts where acc_number=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);
            //step-4: execute jdbc-statement
            ResultSet resultSet = preparedStatement.executeQuery();
            //step-5: process resultset
            if (resultSet.next()) {
                Account account = new Account();
                account.setNumber(resultSet.getString("acc_number"));
                account.setBalance(resultSet.getDouble("acc_balance"));
                return Optional.of(account);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void updateAccount(Account account) {
        Connection connection = null;
        try {
            connection = SQLConnectionFactory.getConnection();
            // step-3: jdbc-statement with SQL query
            String sql = "update accounts set acc_balance=? where acc_number=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setString(2, account.getNumber());
            //step-4: execute jdbc-statement
            int affectedRows = preparedStatement.executeUpdate();
            //step-5: process resultset
            if (affectedRows == 1) {
//                System.out.println("account updated with new data");
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
