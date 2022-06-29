package com.example.service;

import com.example.entity.Account;
import com.example.execeptions.AccountBalanceException;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UPITransferService implements TransferService {


    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional(
            transactionManager = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {AccountBalanceException.class,IllegalStateException.class},
            noRollbackFor = {RuntimeException.class}
    )
    public void transfer(double amount, String sourceAccountNumber, String targetAccountNumber) {
        //logger.info("transfer initiated..");
        Account sourceAccount = accountRepository.findById(sourceAccountNumber).get();
        Account targetAccount = accountRepository.findById(targetAccountNumber).get();
        if (sourceAccount.getBalance() < amount)
            throw new AccountBalanceException("no balance");
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

}
