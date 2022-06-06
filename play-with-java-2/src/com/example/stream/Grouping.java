package com.example.stream;

import com.example.model.Dish;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Grouping {

    private static List<Dish> menu = Dish.menu;

    enum CaloricLevel {DIET, NORMAL, FAT}


    public static void main(String[] args) {

        Map<Dish.Type, List<Dish>> result1 =
                menu.stream()
                        .collect(groupingBy(Dish::getType));

        Map<CaloricLevel, List<Dish>> result2 =
                menu
                        .stream()
                        .collect(groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }));

        System.out.println(result2);


        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> result3 =
                menu
                        .stream()
                        .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })));

        System.out.println(result3);

        Map<Dish.Type, Long> result4 =
                menu
                        .stream()
                        .collect(groupingBy(Dish::getType, counting()));

        System.out.println(result4);

        Map<Dish.Type, Integer> result5 =
                menu.stream()
                        .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        System.out.println(result5);

        Map<Dish.Type, Set<CaloricLevel>> result6=
        menu
                .stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }, toSet()
                )));

        System.out.println(result6);

    }

}
