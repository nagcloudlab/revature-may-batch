package com.example.repository;

import com.example.model.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Account account data-accessing code

public class AccountInMemoryRepository {

    private Map<String, Account> inMemoryAccounts = new HashMap<>(); // MySQL / Postgre

    public AccountInMemoryRepository() {
        inMemoryAccounts.put("1", new Account("1", 1000.00));
        inMemoryAccounts.put("2", new Account("2", 1000.00));
    }

    public Optional<Account> loadAccount(String number) {
        Account account = inMemoryAccounts.get(number);
        if (account == null)
            return Optional.empty();
        else
            return Optional.of(account);
    }

    public void updateAccount(Account account) {
        String accNumber = account.getNumber();
        inMemoryAccounts.put(accNumber, account);
    }

}
