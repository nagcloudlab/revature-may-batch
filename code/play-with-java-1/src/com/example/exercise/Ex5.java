package com.example.exercise;

import java.util.ArrayList;
import java.util.List;

public class Ex5 {

    public static void main(String[] args) {
        List<String> menu = new ArrayList<>();
        menu.add("nveg");
        menu.add("nveg");
        menu.add("veg");
        menu.add("nveg");
        menu.add("veg");

        // replacce all 'nevg; item with '*'

        //way-1
//        for(int i=0;i<menu.size();i++) {
//            if(menu.get(i).equals("nveg")){
//                menu.set(i,"*");
//            }
//        }
//
        //way-2
        menu.replaceAll(item -> {
            if (item.equals("nveg"))
                return "*";
            else
                return item;
        });

        System.out.println(menu);

    }

}
