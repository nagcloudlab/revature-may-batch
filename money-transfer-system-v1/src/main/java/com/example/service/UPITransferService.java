package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Service
@BankService
@Scope("singleton")
//@Profile("dev")
@Lazy(false)
public class UPITransferService implements TransferService {

    private static final Logger logger = Logger.getLogger("mts");

    private AccountRepository accountRepository;

    @Autowired
    public UPITransferService(@Qualifier("jdbc") AccountRepository accountRepository,
                              @Value("${daily.limit:1000}") int dailyTransferLimit) {
        System.out.println(dailyTransferLimit);
        this.accountRepository = accountRepository;
        logger.info("UPITransferService component instantiated");
    }

//    @Autowired(required = false)
//    public void setAccountRepository(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

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
