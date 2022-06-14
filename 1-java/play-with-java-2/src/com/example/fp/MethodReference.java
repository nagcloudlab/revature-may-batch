package com.example.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

//-----------------------------------------------------
// From My Friend
//-----------------------------------------------------
class FoodUtil {
    public static boolean isNonVeg(String item) {
        // lookup is item belongs non-veg category
        return item.equals("non-veg");
    }
}

public class MethodReference {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>();
        menu.add("veg");
        menu.add("veg");
        menu.add("non-veg");
        menu.add("veg");
        menu.add("veg");
        menu.add("non-veg");

//        menu.removeIf(item -> {
//            return FoodUtil.isNonVeg(item);
//        });

        // - or-

        Predicate<String> isNonVeg = FoodUtil::isNonVeg;
        menu.removeIf(isNonVeg); // Method Reference  ( :: ) ==> use existing method as function

        System.out.println(menu);

        //----------------------------------------------------------

        Function<String, Integer> strLenFunc = String::length;

        IntBinaryOperator compareFn1 = (n1, n2) -> Integer.compare(n1, n2);
        // - or
        IntBinaryOperator compareFn2= Integer::compare;

        //-----------------------------------------------------------
    }
}
