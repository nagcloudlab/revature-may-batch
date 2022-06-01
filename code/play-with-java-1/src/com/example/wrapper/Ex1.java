package com.example.wrapper;

public class Ex1 {
    public static void main(String[] args) {

        // is java pure object oriented lang ? No

        // but can we wrap/convert value as objecy ? yes

        // how ? ==> wrapper classes

        // why should wrap ? if you want to store values in 'collections',

        //----------------------------------------------------------------

        int value=12;
        Integer obj1=new Integer(value);
        Integer obj2=value; // Auto-boxing
        value=obj1; // Auto-Un-Boxing

        //-----------------------------------------------------------------

        /*

            Byte
            Short
            Integer
            Long
            Float
            Double
            Character
            Boolean

         */

    }
}

