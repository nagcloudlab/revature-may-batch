package com.example.strings;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter file path?");
        String filePath = scanner.nextLine();
        /*
            c:/dir1/cat1.jpg
            c:/dir1/dir2/cat2.jpg
         */
        String fileName = null;
        fileName=filePath.substring(filePath.lastIndexOf("/")+1);
        System.out.println(fileName);


    }
}
