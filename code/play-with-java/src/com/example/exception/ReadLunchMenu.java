package com.example.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadLunchMenu {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("menu.txt");) {

            int uc = -1;
            while ((uc = fileReader.read()) != -1) {
                System.out.print((char)uc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
