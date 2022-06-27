package com.example.service;

import com.example.config.ApplicationConfiguration;
import com.example.execeptions.AccountBalanceException;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class TransferServiceIntegrationTest {

    @Autowired
    private TransferService transferService;

    @Autowired
    @Qualifier("jdbc")
    private AccountRepository accountRepository;


    @Test
    public void successTransfer() {
        transferService.transfer(0.0, "1", "2");
        Account sourceAccount = accountRepository.loadAccount("1");
        assertEquals(1000.00, sourceAccount.getBalance());
    }

    @Test
    public void balanceException() {
        assertThrows(AccountBalanceException.class, () -> {
            transferService.transfer(10000.00, "1", "2");
        });
    }

}
