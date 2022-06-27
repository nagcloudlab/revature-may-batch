package com.example.repository;

import com.example.model.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository{

    @Override
    public Account loadAccount(String number) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }

}
