package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryStub implements AccountRepository {

    private  Map<String,Account> accounts=new HashMap<>();

   public AccountRepositoryStub(){
       accounts.put("1",new Account("1",1000.00));
       accounts.put("2",new Account("2",1000.00));
   }

    @Override
    public Account loadAccount(String number) {
        return accounts.get(number);
    }

    @Override
    public void updateAccount(Account account) {
        accounts.put(account.getNumber(),account);
    }
}
