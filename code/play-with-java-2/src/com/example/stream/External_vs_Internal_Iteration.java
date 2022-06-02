package com.example.stream;

import java.util.Arrays;
import java.util.List;

public class External_vs_Internal_Iteration {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Iteration:

//        1. External iteration

        int sum = 0;
        for (Integer i : numbers) {
            sum = sum + i;
        }
        System.out.println(sum);

        // 2. Iternal iteration

        sum = numbers
                .stream()
                .mapToInt(n -> n)
                .sum();

        System.out.println(sum);

    }

}
