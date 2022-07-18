package com.example.rest.dto;

import lombok.Data;

@Data
public class ReimbursementRequest {
    private String type;
    private double amount;
}
