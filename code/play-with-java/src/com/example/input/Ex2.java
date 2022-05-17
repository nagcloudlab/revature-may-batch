package com.example.input;


import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("enter number one!");
        int n1=scanner.nextInt();
        System.out.println("enter number two!");
        int n2=scanner.nextInt();
        int sumResult=n1+n2;
        System.out.println("sum - "+sumResult);

    }

}
