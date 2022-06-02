package com.example.stream;

import com.example.model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        // Filtering with predicate
        List<Dish> vegetarianMenu =
        menu
                .stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);


    }

}
