package com.example.basics;

public class Ex2 {
    public static void main(String[] args) {

        // conditional statements
        /*
            - if else
            - switch case
         */

        boolean isFound = true;
        if (isFound)
            System.out.println("Found");
        else
            System.out.println("No Found");

        //--------------------------------------------------

        int i=1;
        switch (i){
            case 1:{
                System.out.println("One");
                break;
            }
            case 2:{
                System.out.println("Two");
                break;
            }
            default:{
                System.out.println("Some other Number");
            }
        }

        //--------------------------------------------------

    }
}
