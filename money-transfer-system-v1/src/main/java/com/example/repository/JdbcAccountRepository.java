package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//@Component
@Repository
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger logger = Logger.getLogger("mts");

    //    @Autowired
    private DataSource dataSource;

    //    @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        logger.info("JdbcAccountRepository component instantiated");
    }

//    @Autowired(required = false)
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }


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
