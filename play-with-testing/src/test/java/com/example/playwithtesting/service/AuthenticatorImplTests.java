package com.example.playwithtesting.service;

// Testing
/*

    A => Arrange
    A => Act
    A => Assert

 */

import com.example.playwithtesting.entity.Account;
import com.example.playwithtesting.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticatorImplTests {

    private Authenticator authenticator;
    AccountRepository accountRepositoryMock;
    // Arrange

    @BeforeEach
    public void setUp() {
//        AccountRepository accountRepositoryStub = new AccountRepositoryStub();
        accountRepositoryMock = mock(AccountRepository.class);
        when(accountRepositoryMock.findById("ledya"))
                .thenReturn(Optional.of(new Account("ledya", "secret")));
        authenticator = new AuthenticatorImpl(accountRepositoryMock);
    }


    @Test
    public void successAuthTest() {
        boolean b = authenticator.authenticate("ledya", "secret");
        assertTrue(b);
        verify(accountRepositoryMock).findById("ledya");
    }

    @Test
    public void failureAuthTest() {
        boolean b = authenticator.authenticate("ledya", "invalid");
        assertFalse(b);
        verify(accountRepositoryMock).findById("ledya");
    }

    @Test
    public void accNotFountTest() {
        assertThrows(IllegalStateException.class, () -> {
            boolean b = authenticator.authenticate("ledyaa", "invalid");
        });
    }

}
