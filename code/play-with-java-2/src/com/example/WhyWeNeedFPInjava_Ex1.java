package com.example;

import com.example.model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class GreenApplePredicate implements Predicate<Apple> {
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

public class WhyWeNeedFPInjava_Ex1 {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // declarative Programming
        // A. class
        List<Apple> greenApples = filterApples(inventory, new GreenApplePredicate());
        for (Apple apple : greenApples) {
            System.out.println(apple);
        }

        System.out.println("-".repeat(50));

        //B. Anonymous inner class
        Predicate<Apple> greenApplePredicate1 = new Predicate<>() {
            public boolean test(Apple o) {
                return "green".equals(o.getColor());
            }
        };
        greenApples = filterApples(inventory, greenApplePredicate1);
        for (Apple apple : greenApples) {
            System.out.println(apple);
        }

        System.out.println("-".repeat(50));

        // C. Function a.k.a Lambda Expression
        Predicate<Apple> greenApplePredicate2 = (apple) -> "green".equals(apple.getColor());
        for (Apple apple : greenApples) {
            System.out.println(apple);
        }

        /*
            Why we need FP ?
            - to write compact & concise code
         */

    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
