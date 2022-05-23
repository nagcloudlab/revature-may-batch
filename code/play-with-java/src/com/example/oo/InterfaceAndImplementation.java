package com.example.oo;

//-------------------------------------------------------
// Team-1 : PriceMatrix ( dependency )
//-------------------------------------------------------

//-----------------------------------
// interface  => Abstraction of an object
//-----------------------------------
interface PriceMatrix {
    public abstract double getPrice(String cartItem); // abstract methods
}
//-----------------------------------
// class => Implementation / Encapsulation of an object
//-----------------------------------
// 2 implementation(s)
class PriceMatrix_v1 implements PriceMatrix {
    public double getPrice(String cartItem) {
        return 100.00;
    }
}

class PriceMatrix_v2 implements PriceMatrix {
    public double getPrice(String cartItem) {
        return 200.00;
    }
}

//-------------------------------------------------------
// PriceMatrix Factory ( centralize/isolate complex object creation from real code )
//-------------------------------------------------------
class PriceMatrixFactory {
    static PriceMatrix getPriceMatrix(String version) {
        if (version.equals("v1")) {
            return new PriceMatrix_v1();
        }
        if (version.equals("v2")) {
            return new PriceMatrix_v2();
        }
        return null;
    }
}

//-------------------------------------------------------
// Team-2 : Billing  ( dependent )
//-------------------------------------------------------

interface Billing {
    double getTotalPrice(String[] cart);
}

class BillingImpl implements Billing {
    PriceMatrix priceMatrix;
    BillingImpl() {
        this.priceMatrix = PriceMatrixFactory.getPriceMatrix("v2");
    }
    public double getTotalPrice(String[] cart) {
        double total = 0.0;
        //this.priceMatrix=PriceMatrixFactory.getPriceMatrix();
        for (int i = 0; i < cart.length; i++) {
            String cartItem = cart[i];
            total += priceMatrix.getPrice(cartItem);
        }
        return total;
    }
}


public class InterfaceAndImplementation {
    public static void main(String[] args) {
        // init / booting
        Billing billing = new BillingImpl();
        // use
        String[] cart1 = {"123123", "345345", "4564564"};
        double totalPrice = billing.getTotalPrice(cart1);
        System.out.println(totalPrice);

        String[] cart2 = {"123123", "345345", "4564564", "34234234"};
        totalPrice = billing.getTotalPrice(cart2);
        System.out.println(totalPrice);

    }
}
