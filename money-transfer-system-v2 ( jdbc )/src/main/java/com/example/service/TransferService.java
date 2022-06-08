package com.example.service;

public interface TransferService {
    // Use-cases
    void transfer(double amount, String sourceAccNumber, String targetAccNumber);
}
