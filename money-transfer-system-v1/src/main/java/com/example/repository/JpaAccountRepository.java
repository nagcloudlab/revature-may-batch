package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

// Vincent
public class JpaAccountRepository implements AccountRepository{

    private static final Logger logger = Logger.getLogger("mts");

    public JpaAccountRepository() {
        logger.info("JpaAccountRepository component instantiated");
    }

    public Account loadAccount(String number) {
        logger.info("loading account - "+number);
        //..
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        logger.info("updating account - "+account.getNumber());
        //..
    }
}
