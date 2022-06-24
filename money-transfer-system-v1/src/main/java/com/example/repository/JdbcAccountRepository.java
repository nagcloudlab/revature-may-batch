package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcAccountRepository implements AccountRepository {

    private static final Logger logger = Logger.getLogger("mts");

    private DataSource dataSource;

    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        logger.info("JdbcAccountRepository component instantiated");
    }

    public Account loadAccount(String number) {
        logger.info("loading account - " + number);
        try {
            Connection conn = dataSource.getConnection();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //..
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        logger.info("updating account - " + account.getNumber());
        //..
    }

}
