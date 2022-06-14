package com.example.repository;

import com.example.model.Account;

import java.util.Optional;

public interface AccountRepository {

    // repository can hold data accessing operation for specific datasource

    Optional<Account> loadAccount(String number);
    void updateAccount(Account account);

}
