package com.example.repository;

import com.example.entity.Transaction;

import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction);
    List<Transaction> findAll();
}
