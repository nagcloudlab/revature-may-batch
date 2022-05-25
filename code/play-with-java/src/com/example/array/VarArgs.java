package com.example.array;


public class VarArgs {

    public static void main(String[] args) {
        int n1 = 12;
        int n2 = 13;
        int n3 = 14;
        int n4 = 15;
        display1(new int[]{n1, n2, n3});
        display2(n1, n2, n3);

    }

    private static void display1(int[] args) {
        for (int n : args) {
            System.out.println(n);
        }
    }

    // method with VarArgs syntax
    private static void display2(int... args) {
//        for (int n : args) {
//            System.out.println(n);
//        }
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
