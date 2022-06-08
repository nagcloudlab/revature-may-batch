package com.example.service;

import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TxnType;
import com.example.exceptions.AccountNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;

public class TransferServiceImpl implements TransferService {

    private static final Logger LOG = Logger.getLogger("mts"); // singleton


    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public TransferServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void transfer(double amount, String sourceAccNumber, String targetAccNumber) {
        // load accounts
        Account sourceAccount = accountRepository
                .findById(sourceAccNumber)
                .orElseThrow(() -> new AccountNotFoundException("account not found - " + sourceAccNumber));

        Account targetAccount = accountRepository
                .findById(targetAccNumber)
                .orElseThrow(() -> new AccountNotFoundException("account not found - " + targetAccNumber));

        // debit & credit
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);


        Transaction debitTransaction = new Transaction();
        debitTransaction.setType(TxnType.DEBIT);
        debitTransaction.setAmount(amount);
        debitTransaction.setLocalDateTime(LocalDateTime.now());
        debitTransaction.setAccount(sourceAccount);

        Transaction creditTransaction = new Transaction();
        creditTransaction.setType(TxnType.CREDIT);
        creditTransaction.setAmount(amount);
        creditTransaction.setLocalDateTime(LocalDateTime.now());
        creditTransaction.setAccount(targetAccount);

        transactionRepository.save(debitTransaction);
        transactionRepository.save(creditTransaction);

        // update Accounts
        accountRepository.update(sourceAccount);
        accountRepository.update(targetAccount);


        LOG.info("transfer completed");


    }


}
