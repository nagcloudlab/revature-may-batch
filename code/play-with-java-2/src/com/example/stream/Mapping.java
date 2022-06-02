package com.example.stream;

import com.example.model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Mapping {
    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths =
                words.stream()
                        .map(String::length)
                        .collect(toList());
        System.out.println(wordLengths);


        // flatMap
//        String[] m = new String[]{
//                "idly,vada,poori,rice",
//                "rice,chapathi,chicken",
//                "biryani,chicken,rice"
//        };
//
//
//        Arrays.stream(m)
//                .flatMap(s-> Arrays.stream(s.split(",")))
//                .distinct()
//                .forEach(e->System.out.println(e));


        int[] numbers = {1,2,3};

//        1 -> 1 , 1*1 , 1*1*1
//        2 -> 2 , 2*2 , 2*2*2


       int[] r= Arrays
                .stream(numbers)
                .flatMap(n-> Arrays.stream(new int[]{n,n*n,n*n*n}))
                .toArray();

        System.out.println(Arrays.toString(r));

    }
}
