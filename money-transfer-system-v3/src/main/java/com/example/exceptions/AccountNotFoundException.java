package com.example.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String s) {
        super(s);
    }
}
