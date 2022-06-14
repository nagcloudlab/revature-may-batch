package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Account account data-accessing code

public class InMemoryAccountRepository implements AccountRepository {

    private static final Logger LOGGER = Logger.getLogger("mts");

    private Map<String, Account> inMemoryAccounts = new HashMap<>(); // MySQL / Postgre

    public InMemoryAccountRepository() {
        inMemoryAccounts.put("1", new Account("1", 1000.00));
        inMemoryAccounts.put("2", new Account("2", 1000.00));
//        System.out.println("AccountInMemoryRepository instance created..");
        LOGGER.info("AccountInMemoryRepository instance created..");
    }

    public Optional<Account> loadAccount(String number) {
//        System.out.println("loading account - " + number);
        LOGGER.info("loading account - " + number);
        Account account = inMemoryAccounts.get(number);
        if (account == null)
            return Optional.empty();
        else
            return Optional.of(account);
    }


    public void updateAccount(Account account) {
//        System.out.println("updating account - " + account.getNumber());
        LOGGER.info("updating account - " + account.getNumber());
        String accNumber = account.getNumber();
        inMemoryAccounts.put(accNumber, account);
    }

}
