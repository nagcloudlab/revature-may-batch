package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import org.apache.log4j.Logger;

// Alberto
public class UPITransferService implements TransferService {

    private static final Logger logger = Logger.getLogger("mts");

    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService component instantiated");
    }

    @Override
    public void transfer(double amount, String sourceAccountNumber, String targetAccountNumber) {

        logger.info("transfer initiated..");

        Account sourceAccount = accountRepository.loadAccount(sourceAccountNumber);
        Account targetAccount = accountRepository.loadAccount(targetAccountNumber);

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        logger.info("debit");
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        logger.info("credit");

        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(targetAccount);

        logger.info("transfer finished..");

    }

}
