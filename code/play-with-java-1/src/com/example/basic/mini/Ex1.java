package com.example.basic.mini;

public class Ex1 {
    static int staVar;
    int insVar;

    public static void main(String[] args) {
        int localvar;
        localvar = 10;
        /*
            impo-note:
            Local variable must be intialized before use
         */
        System.out.println(localvar);
        int j = localvar + 1;
    }
}
