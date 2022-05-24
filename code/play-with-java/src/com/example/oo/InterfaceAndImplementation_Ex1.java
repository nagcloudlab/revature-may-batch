package com.example.oo;


//----------------------------------------------------------------
// team-1 => pricematrix
//----------------------------------------------------------------

interface PriceMatrix {
    double getPrice(String cartItem);
}

class Pricematrix_v1 implements PriceMatrix {

    public double getPrice(String cartItem) {
        //...
        return 100.00;
    }

    public void m1() {
    }

    public void m2() {
    }
}

class Pricematrix_v2 implements PriceMatrix {
    public double getPrice(String cartItem) {
        //...
        return 200.00;
    }
}

class Pricematrix_v3 implements PriceMatrix {
    public double getPrice(String itemCode) {
        //..
        return 300.00;
    }
}

//----------------------------------------------------------------
// PriceMatrix Factory
//----------------------------------------------------------------

class PriceMatrixFactory {
    public static PriceMatrix getPriceMatrix(String version) {
        if (version.equals("v1")) {
            return new Pricematrix_v1();
        }
        if (version.equals("v2")) {
            return new Pricematrix_v2();
        }
        return new Pricematrix_v3();
    }
}

//----------------------------------------------------------------
// team-2 => Billing
//----------------------------------------------------------------

class BillingImpl {
    // composition  a.k.a HAS-A relationship
    PriceMatrix priceMatrix = null;
    public BillingImpl(String priceMatrixVersion) {
        this.priceMatrix = PriceMatrixFactory.getPriceMatrix(priceMatrixVersion);
    }

    public double getTotalPrice(String[] cart) {
        double totalPrice = 0;
        //PriceMatrix priceMatrix = PriceMatrixFactory.getPriceMatrix("v3"); // Never do
        for (int i = 0; i < cart.length; i++) {
            String cartItem = cart[i];
            totalPrice += priceMatrix.getPrice(cartItem);
        }
        return totalPrice;
    }
}

//---------------------------------------------------------------

public class InterfaceAndImplementation_Ex1 {
    public static void main(String[] args) {

        BillingImpl billing = new BillingImpl("v3");

        String[] cart1 = {"1", "2", "3"};
        double totalPrice = billing.getTotalPrice(cart1);
        System.out.println(totalPrice);

    }
}
