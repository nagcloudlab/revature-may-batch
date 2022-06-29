package com.example.billing;

import com.example.pricematrix.PriceMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ob")
public class OnlineBilling implements Billing {

    private PriceMatrix priceMatrix;

    @Autowired
    public OnlineBilling(@Qualifier("priceMatrix_v2") PriceMatrix priceMatrix) {
        this.priceMatrix = priceMatrix;
    }

    @Override
    public double getTotalPrice(List<String> cart) {
        double total = 0.0;
        for (String itemCode : cart) {
            total += priceMatrix.getPrice(itemCode);
        }
        return total;
    }
}
