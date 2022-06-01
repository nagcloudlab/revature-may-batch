package com.example.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HowToSortListColln_Ex2 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("Nag");
        list.add("Indu");
        list.add("Riya");
        list.add("Diya");


        Comparator<String> byDsc = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        Collections.sort(list, byDsc);

        for (String name : list) {
            System.out.println(name);
        }

    }
}
