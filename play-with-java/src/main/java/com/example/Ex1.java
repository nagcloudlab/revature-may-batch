package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {

    public static void main(String[] args) {

        // input  ( collection of elements )

        // with iteration
        // filtering
        // transforming
        // sorting
        // min, max , sum , avg
        // grouping
        // partition
        // count
        // output


        //--------------------------------------------------------
        // How to write code to process collection of elements,
        //--------------------------------------------------------

        // way-1 : imperative style

        List<Integer> input = List.of(1, 3, 5, 7, 9, 2, 4, 6, 8, 10); // 10m
        List<Integer> output = new ArrayList<>();
        // External Iteration + Filtering ==> for odd numbers
        for (int i : input) {
            if (i % 2 == 0) {
                output.add(i);
            }
        }

        // way-2 : Declarative / Functional style with stream api

        output = input
                .stream()
                .parallel()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());


    }

}
