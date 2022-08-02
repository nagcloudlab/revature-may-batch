package com.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex2 {
    public static void main(String[] args) {

        // Find The First Non Repeated Character In A String


        String str = "revature";

        // Solution-1:
//        for (char c : str.toCharArray()) {
//            if (str.indexOf(c) == str.lastIndexOf(c)) {
//                System.out.println(c);
//                break;
//            }
//        }

        // Solution-2

//        Map<Character, Integer> map = new LinkedHashMap<>();
//        for (char c : str.toCharArray()) {
//            if (map.containsKey(c)) {
//                map.put(c, map.get(c) + 1);
//            } else {
//                map.put(c, 1);
//            }
//        }
//        for(Character c:map.keySet()){
//            if(map.get(c)==1){
//                System.out.println(c);
//                break;
//            }
//        }


        // Solution-3 : from vincent

//        int count = 0;
//        int index = -1;
//        for (int i = 0; i < str.length(); i++) {
//            count = str.length() - str.replaceAll("" + str.charAt(i), "").length();
//            if (count == 1) {
//                index = i;
//                i = str.length();
//            }
//        }
//
//        if (index != -1)
//            System.out.println("the first character that doesnt repeat is: " + str.charAt(index));




    }
}
