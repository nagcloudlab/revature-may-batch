package com.example.strings;

public class Ex2 {

    public static void main(String[] args) {

//        StringBuffer profile = new StringBuffer(""); // thread-safe
        StringBuilder profile = new StringBuilder(""); // not-thread-safe
        profile.append("Name - Nag \n");
        profile.append("Age - 38 \n");
//        profile.reverse();


        String out = profile.toString();
        System.out.println(out);

    }

}