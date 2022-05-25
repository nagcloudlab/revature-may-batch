package com.example.array;

public class Enhanced_For_Loop {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40};
        // traditional for-loop
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            System.out.println(n);
        }

        // JDK 1.5  , Enhanced for-loop
        for (int n : numbers) {
            System.out.println(n);
        }

    }

}
