package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LazyStream {

    private static Consumer<Integer> println;

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 3, 2, 6, 5, 7, 2, 5, 8, 0, 1);

        Stream<Integer> stream = integers
                .stream()
                // intermediate method(s)
                .filter(n -> {
//                    System.out.println("filtering - " + n);
                    return n % 2 != 0;
                });

        System.out.println("-".repeat(50));

        stream
                .forEach(System.out::println);

//        System.out.println("-".repeat(50));
//
//        stream
//                .forEach(System.out::println);  // error . stream closed

    }

}
