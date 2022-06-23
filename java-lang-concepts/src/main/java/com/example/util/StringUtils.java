package com.example.util;

public class StringUtils {

    public static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        String reverseString=sb.reverse().toString();
        return s.equals(reverseString);
    }

}
