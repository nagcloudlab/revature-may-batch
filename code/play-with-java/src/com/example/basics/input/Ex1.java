package com.example.basics.input;


import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hey, say your name?");
        String name=scanner.nextLine();
        System.out.println("hey, can u say your age as well ?");
        int age=scanner.nextInt();
        System.out.println("hello "+name+" your age is  "+age);
    }
}
