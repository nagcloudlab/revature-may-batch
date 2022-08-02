package com.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex3 {
    public static void main(String[] args) {
       String str="revature";

       Map<Character,Long> map=
       str
               .chars()
               .mapToObj(uc->(char)uc)
               .collect(Collectors.groupingBy(c->c,Collectors.counting()));

        System.out.println(map);
    }


}
