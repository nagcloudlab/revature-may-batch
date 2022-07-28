package com.example.service;

import com.example.execeptions.AccountBalanceException;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransferServiceUnitTest {

    private TransferService transferService;
    private AccountRepository accountRepository;

    Account sourceAccount = new Account("1", 1000.00);
    Account targetAccount = new Account("2", 1000.00);

    // Unit-Testing ==> AAA
    // A=> Arrange
    // A=> Act
    // A=> Assert

    @BeforeEach
    public void beforeEach() {
//        accountRepository=new AccountRepositoryStub();
        accountRepository = mock(AccountRepository.class);
        when(accountRepository.loadAccount("1")).thenReturn(sourceAccount);
        when(accountRepository.loadAccount("2")).thenReturn(targetAccount);
        doNothing().when(accountRepository).updateAccount(sourceAccount);
        doNothing().when(accountRepository).updateAccount(targetAccount);
        transferService = new UPITransferService(accountRepository, 10);
    }

    @Test
    public void successTransfer() {
        transferService.transfer(100.00, "1", "2");
        Account sourceAccount = accountRepository.loadAccount("1");
        assertEquals(900.00, sourceAccount.getBalance());
    }

    @Test
    public void balanceException() {
        assertThrows(AccountBalanceException.class, () -> {
            transferService.transfer(10000.00, "1", "2");
        });
    }

}
