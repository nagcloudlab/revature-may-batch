package com.example.array;

public class PrimitiveArray {

    public static void main(String[] args) {

        int number = 12;
        int[] numbers = new int[10]; // array
        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
            numbers[i] = i * i;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
//        numbers[10]=100; // cause exception
        System.out.println(numbers[9]);


    }

}
