package com.example.stream;

import com.example.model.Dish;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;

public class NumericStreams {
    public static void main(String[] args) {

        List<Dish> menu=Dish.menu;
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories:" + calories);

        IntSummaryStatistics statistics = menu.stream()
                .mapToInt(Dish::getCalories)
                .summaryStatistics();

        System.out.println(statistics.getSum());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());

        System.out.println(statistics);



    }
}
