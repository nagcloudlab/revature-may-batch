package com.example.exercise;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {

    public static void main(String[] args) {

        int[] numbers = {
                1, 2, 1, 1, 2, 3, 4, 5, 3
        };
        List<Integer> usedNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int n1 = numbers[i];
            int count = 0;
            if (!usedNumbers.contains(n1)) {
                for (int j = 0; j < numbers.length; j++) {
                    int n2 = numbers[j];
                    if (n1 == n2) {
                        count++;
                    }
                }
                System.out.println(n1 + " - " + count);
                usedNumbers.add(n1);
            }

        }


    }


}
