package com.example.stream;

import com.example.model.Dish;

import java.util.List;
import java.util.Optional;

public class Finding {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

//        boolean isVegetarianFriendlyMenu=
//                menu
//                        .stream()
//                        .anyMatch(Dish::isVegetarian);
//
//        System.out.println(isVegetarianFriendlyMenu);

//        boolean isHealthyMenu =
//                menu
//                        .stream()
//                       // .allMatch(d -> d.getCalories() < 1000);
//                               .noneMatch(d->d.getCalories() > 1000);
//        System.out.println(isHealthyMenu);


        Optional<Dish> optional = menu
                .stream()
                .filter(Dish::isVegetarian)
                .findFirst();
//                .findAny();

        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("No Veg Item");
        }


    }

}
