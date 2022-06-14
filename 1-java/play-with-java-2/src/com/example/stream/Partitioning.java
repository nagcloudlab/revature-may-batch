package com.example.stream;

import com.example.model.Dish;

import static java.util.Comparator.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class Partitioning {

    private static List<Dish> menu = Dish.menu;


    public static void main(String[] args) {

        Map<Boolean, List<Dish>> result1 =
                menu
                        .stream()
                        .collect(partitioningBy(Dish::isVegetarian));

        System.out.println(result1);

        Map<Boolean, Map<Dish.Type, List<Dish>>> result2 =
                menu
                        .stream()
                        .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(result2);


        Map<Boolean, Object> result3 =
                menu
                        .stream()
                        .collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println(result3);
    }
}
