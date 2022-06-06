package com.example.quiz;

public class Quiz1 {

    public static void main(String[] args) {

        StringBuffer sb1=new StringBuffer("");
        sb1.append("A");
        StringBuffer sb2=sb1;
        sb2.append("B");
        sb2=sb1;
        StringBuffer sb3=sb2;
        sb2.append("C");
        sb3=sb1;

        System.out.println(sb1==sb1);
        System.out.println(sb2==sb3);
        System.out.println(sb1==sb3);

        System.out.println(sb1.equals(sb2));
        System.out.println(sb2.equals(sb3));
        System.out.println(sb1.equals(sb3));

    }

}
