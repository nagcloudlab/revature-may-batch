package com.example.exception;


public class Try_Catch_Ex1 {

    public static void main(String[] args) {

        System.out.println("A");
        try {
            System.out.println("B");
            int div = 1 / 0; // throw new ArithmaticException("/ by zero")
            System.out.println("C");
        } catch (ArithmeticException e) {
            /*
             // what to do here ?
                => give friendly message to end-user
                => log exception in log-file for future fix
                => re-throw the exception to other modules
             */
            System.out.println("D");
            System.out.println("Ex-" + e.getMessage());
        }
        System.out.println("E");


    }

}
