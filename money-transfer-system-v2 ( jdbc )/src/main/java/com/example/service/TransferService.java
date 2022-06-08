package com.example.service;

// business logic

import com.example.exception.AccountNotFoundException;
import com.example.model.Account;
import com.example.repository.InMemoryAccountRepository;
import com.example.repository.JdbcAccountRepository;
import org.apache.log4j.Logger;

public class TransferService {

    private static final Logger LOGGER = Logger.getLogger("mts");

    //InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();
    JdbcAccountRepository accountRepository = new JdbcAccountRepository();

    public TransferService() {
//        System.out.println("TransferService instance created...");
        LOGGER.info("TransferService instance created...");
    }

    public void transfer(double amount, String sourceAccNumber, String targetAccNumber) {

//        System.out.println("transfer initiated.."); // IO , millis
        LOGGER.info("transfer initiated.."); // separate thread

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

        // update Accounts
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(targetAccount);

        LOGGER.info("transfer completed");

    }

}