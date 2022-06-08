package com.example.repository;

import com.example.entity.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(String number);
    void update(Account account);

}
