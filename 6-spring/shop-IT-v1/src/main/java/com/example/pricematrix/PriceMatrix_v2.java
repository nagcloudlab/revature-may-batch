package com.example.pricematrix;

import org.springframework.stereotype.Component;

@Component
public class PriceMatrix_v2 implements PriceMatrix{

    @Override
    public double getPrice(String itemCode) {
        return 200.00;
    }
}
