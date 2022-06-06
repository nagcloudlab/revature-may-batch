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
        numbers
                .stream()
                .distinct()
                .forEach(System.out::println);


//        List<Dish> dishesLimit3=
//                menu
//                        .stream()
//                        .filter(d->d.getCalories()>300)
//                        .limit(3)
//                        .collect(Collectors.toList());
//        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip2 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .skip(3)
                        .collect(Collectors.toList());

        dishesSkip2.forEach(System.out::println);

    }

}
