package com.example.collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetColln_Ex3 {

    public static void main(String[] args) {

        Set<String> colln = new LinkedHashSet<>();
        colln.add("E");
        colln.add("A");
        colln.add("C");
        colln.add("D");
        colln.add("E");

        System.out.println(colln);

    }

}
