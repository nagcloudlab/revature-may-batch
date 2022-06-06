package com.example.fp;

import java.util.function.*;


public class HowToCreateFunctionInJava {
    public static void main(String[] args) {

        // How to create Lambda Expression in Java
        // ans : using Functional Interface

        Function<String, Integer> function = (s) -> {
            //...
            return 123;
        };
        BiFunction<String, String, String> biFunction = (s1, s2) -> {
            //...
            return s1 + s1;
        };
        ToIntBiFunction<String, String> toIntBiFunction = (s1, s2) -> {
            return s1.length() + s2.length();
        };

        Consumer<String> consumer = s -> {
        };
        BiConsumer<String, String> biConsumer = (s1, s2) -> {
        };

        Predicate<String> predicate = s -> true;
        BiPredicate<String, Integer> biPredicate = (s, i) -> false;

        Supplier<String> supplier = () -> {
            return "hello";
        };

        //-----------------------------------------------------------------------


        BiFunction<Integer, Integer, Integer> add = (n1, n2) -> {
            return n1 + n2;
        };

        System.out.println(add.apply(12, 13));

        // if function working primimitives ( i.e values ) ,
        // prefer primitive version of Functional Interfaces

        IntBinaryOperator sum = (n1, n2) -> {
            return n1 + n2;
        };

        System.out.println(sum.applyAsInt(12, 13));

        UnaryOperator<String> unaryOperator = s -> s.toUpperCase();
        IntBinaryOperator intBinaryOperator = (n1, n2) -> n1 + n2;


    }
}
