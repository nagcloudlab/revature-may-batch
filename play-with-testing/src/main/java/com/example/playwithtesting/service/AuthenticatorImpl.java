package com.example.playwithtesting.service;


import com.example.playwithtesting.entity.Account;
import com.example.playwithtesting.repository.AccountRepository;

/**
 * Ledya
 */
public class AuthenticatorImpl implements Authenticator {

    private AccountRepository accountRepository;

    public AuthenticatorImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Account account = accountRepository.findById(username)
                .orElseThrow(() -> new IllegalStateException("account not found"));
        if (account.getPassword().equals(password))
            return true;
        else
            return false;
    }

}
