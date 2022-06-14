package com.example.fp;

import java.util.ArrayList;
import java.util.List;

public class FPInJava_Ex3 {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);  //1*1
        numbers.add(2);  //2*2
        numbers.add(3);
        numbers.add(4);

        //way-1 : imperative style
//        for (int i = 0; i < numbers.size(); i++) {
//            int n = numbers.get(i);
//            numbers.set(i, n * n);
//        }
//        System.out.println(numbers);

        //way-2 : Functional Programming
        numbers.replaceAll(n -> n * n);
        System.out.println(numbers);


    }

}
