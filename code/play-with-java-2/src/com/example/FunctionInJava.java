package com.example;


interface Adder {
    int add(int n1, int n2);
}

public class FunctionInJava {

    public static void main(String[] args) {

        // Anynymous inner Class  ( upto JDK 1.7 )
        Adder adder1 = new Adder() {
            public int add(int n1, int n2) {
                return n1 + n2;
            }
        };

        int r = adder1.add(12, 13);
        System.out.println(r);


        // Lambda Expression a.k.a Function ( From JDK 1.8 )
//        Adder adder2 = (int n1, int n2) -> n1 + n2;
        // - or-
//        Adder adder2 = (n1, n2) -> n1 + n2;
        // -or-
        Adder adder2 = (int x, int y) -> {
            int s = x + y;
            return s;
        };


        int rr = adder2.add(12, 13);
        System.out.println(rr);


    }

}
