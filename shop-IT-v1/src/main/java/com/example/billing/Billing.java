package com.example.billing;

import java.util.List;

public interface Billing {

    double getTotalPrice(List<String> cart);

}
