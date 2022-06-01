package com.example.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HowToSortListColln_Ex3 {

    public static void main(String[] args) {

        // Why we need wrapper classes

        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(4);

        // Lambda Expression
        Collections.sort(numbers,(n1,n2)->Integer.compare(n2,n1));

        System.out.println(numbers);


    }

}
