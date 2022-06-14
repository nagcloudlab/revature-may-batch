package com.example.stream;

import java.util.Arrays;
import java.util.List;

public class HowToWorkWithStreamAPI {

    public static void main(String[] args) {

        /*
            3 steps
            step-1 :  create/open stream from any data-source ( e.g array,collection,.. )
            step-2 :  hook intermediate operation(s) based on data-procesing req ( e.g filter,sort )
            step-3 :  collect result
         */

        List<Integer> integers = Arrays.asList(1, 3, 2, 6, 5, 7, 2, 5, 8, 0, 1);


        integers
                .stream() //step-1
                .limit(3) // step-2
                .peek(n -> System.out.println("before filter : " + n))
                .filter(n -> n % 2 != 0)  // step-2
                .peek(n -> System.out.println("after filter : " + n))
                .limit(1) // step-2
                .forEach(System.out::println);  // step-3

    }

}
