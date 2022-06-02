package com.example.fp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WhyWeNeedFPInJava_Ex4 {

    public static void main(String[] args) {


        List<String> family = new ArrayList<>();
        family.add("nag");
        family.add("indu");
        family.add("riya");
        family.add("diya");

        Collections.sort(family,(o1,o2) -> o2.compareTo(o2));

        System.out.println(family);

    }

}
//
//class ByNameDesc implements Comparator<String>{
//    @Override
//    public int compare(String o1, String o2) {
//        return o2.compareTo(o1);
//    }
//}
