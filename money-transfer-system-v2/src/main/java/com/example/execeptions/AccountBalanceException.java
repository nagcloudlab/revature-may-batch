package com.example.execeptions;

public class AccountBalanceException extends RuntimeException{
    public AccountBalanceException(String no_balance) {
        super(no_balance);
    }
}
