package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger logger = Logger.getLogger("mts");

    @Autowired
    private JdbcTemplate jdbcTemplate;
//
//    //    @Autowired
//    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//        logger.info("JdbcAccountRepository component instantiated");
//    }


    public Account loadAccount(String number) {
        String sql = "select * from accounts  where number=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            return new Account(rs.getString("number"), rs.getDouble("balance"));
        }, number);
    }

    public void updateAccount(Account account) {
        String sql = "update accounts set balance=?  where number=?";
        jdbcTemplate.update(sql, account.getBalance(), account.getNumber());
    }

}
