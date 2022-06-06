package com.example.stream;

import com.example.model.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {


    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;
        List<String> lowCaloricDishesNames = lowCaloricDishesNamesV2(menu);
        System.out.println(lowCaloricDishesNames);

    }

    private static List<String> lowCaloricDishesNamesV1(List<Dish> menu) {
        // imperative style
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCaloricDishesNames = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesNames.add(d.getName());
        }
        return lowCaloricDishesNames;
    }

    // streams api  ( jdk 1.8 )
    private static List<String> lowCaloricDishesNamesV2(List<Dish> menu) {
        return menu
                .stream() // loop through
                .filter(d -> d.getCalories() < 400)
                .sorted((o1, o2) -> Integer.compare(o1.getCalories(), o2.getCalories()))
                .map(d -> d.getName())
                .collect(Collectors.toList());
    }

    // streams api
    private static List<String> lowCaloricDishesNamesV3(List<Dish> menu) {
        return menu
                .stream() // loop through
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }


}
