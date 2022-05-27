package com.example.generics;


public class Ex2 {

    // generic methods
    public static <E> void display(E ele) {
        System.out.println(ele);
    }

    public static void main(String[] args) {

        display("string");
        display(123);
        display(true);

    }
}
