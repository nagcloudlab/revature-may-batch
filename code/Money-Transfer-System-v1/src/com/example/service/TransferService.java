package com.example.service;

// business logic

import com.example.exception.AccountNotFoundException;
import com.example.model.Account;
import com.example.repository.AccountInMemoryRepository;

public class TransferService {

    public void transfer(double amount, String sourceAccNumber, String targetAccNumber) {

        AccountInMemoryRepository accountRepository = new AccountInMemoryRepository();

        // load accounts
        Account sourceAccount = accountRepository
                .loadAccount(sourceAccNumber)
                .orElseThrow(() -> new AccountNotFoundException("account not found - " + sourceAccNumber));

        Account targetAccount = accountRepository
                .loadAccount(targetAccNumber)
                .orElseThrow(() -> new AccountNotFoundException("account not found - " + targetAccNumber));

        // debit & credit
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);


        System.out.println(sourceAccount);
        System.out.println(targetAccount);

        // update Accounts
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(targetAccount);

    }

}
