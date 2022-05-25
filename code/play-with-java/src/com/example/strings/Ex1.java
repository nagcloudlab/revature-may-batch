package com.example.strings;

import java.lang.*;
import java.util.Locale;

public class Ex1 {

    public static void main(String[] args) {

        //--------------------------------------------------------------------------------------
//
//        String s1 = new String("Nag");
//        String s2 = new String("Nag");
//
//        System.out.println(s1 == s2); // false // compare references
//        System.out.println(s1.equals(s2)); // compare characters

//        String s3 = "revature";
//        String s4 = "revature";
//
//        System.out.println(s3 == s4); // true
//        System.out.println(s3.equals(s4));

        //--------------------------------------------------------------------------------------

//        String company = "revature";
//        String inCompany = company.concat("-india");
//
//        System.out.println(company);


        //--------------------------------------------------------------------------------------
        // String obj's methods
        //--------------------------------------------------------------------------------------

        String ex = "abcdecfgh";
        System.out.println(ex.charAt(7));
        System.out.println(ex.length());
        System.out.println(ex.startsWith("ab"));
        System.out.println(ex.endsWith("ab"));
        System.out.println(ex.contains("cde"));
        System.out.println(ex.toUpperCase());
        System.out.println(ex.toLowerCase());
        System.out.println(ex.substring(4));
        System.out.println(ex.substring(4, 6));
        System.out.println(ex.indexOf('e'));
        System.out.println(ex.indexOf("cde"));
        System.out.println(ex.indexOf('z'));
        System.out.println(ex.indexOf('c'));
        System.out.println(ex.lastIndexOf('c'));


        String s1 = "  ";
        System.out.println(s1.isEmpty());
        System.out.println(s1.isBlank());


        String s2 = "    Nag N    ";
        System.out.println(s2.trim());


        String s3 = "Abc";  // a => 97
        String s4 = "abc";  // A => 65

        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        System.out.println(s3.equalsIgnoreCase(s4));
        System.out.println(s3.compareTo(s4));
        System.out.println(s3.compareToIgnoreCase(s4));

        String mobile = "1234567890";
        boolean isValid = mobile.matches("\\d{10}");
        System.out.println(isValid);

        String menu = "chicken,mutton,fish";
        String[] menuItems = menu.split(",");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(menuItems[i]);
        }

        String s5 = "abcdaeafa";
        System.out.println(s5.replace('a', 'A'));

        String s6 = "abcde";
        char[] chars = s6.toCharArray();

        System.out.println("**".repeat(10));

        String s = String.format("this is number %d", 12);
        System.out.println(s);

        int value = 12;
        String ss = String.valueOf(value);
        value = Integer.parseInt(ss);
        /*

            in java , ingeneral rule,
            any input / output to exterbal source must be in string

         */
        String n1="1";
        String n2="2";
        int sumeResult=Integer.parseInt(n1)+Integer.parseInt(n2);
        String s8=String.valueOf(sumeResult);
        System.out.println(s8);


    }

}
