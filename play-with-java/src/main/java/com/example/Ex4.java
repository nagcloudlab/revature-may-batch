package com.example;

public class Ex4 {
    public static void main(String[] args) {

        String str="hello";
        str=new StringBuilder(str).reverse().toString();
        System.out.println(str);

    }
}
