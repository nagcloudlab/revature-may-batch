package com.example.fp2;


import java.util.function.Predicate;

public class Ex1 {

    public static void main(String[] args) {

        m1(123);
        m2("hello");
        m3(s -> true);  // bevior parameterization

    }

    public static void m1(int arg1) {
        System.out.println(arg1 + 10);
    }

    public static void m2(String arg1) {
        System.out.println(arg1.toUpperCase());
    }

    public static void m3(Predicate<String> arg1) {
        boolean b = arg1.test("hello");
    }

}
