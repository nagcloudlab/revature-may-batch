package com.example.exercise;

public class Ex2 {

    public static void main(String[] args) {
        /*
            format => name,dep,salary
         */
        // input
        String[] csvReport = {
                "A,IT,1000.00",
                "B,IT,2000.00",
                "C,HR,4000.00",
                "D,SALES,4000.00",
                "E,HR,4000.00"
        };

        // output
        /*

        calculate total salary of earch department

            IT - 3000
            HR - 8000
            SALES - 4000

         */

        String[][] summary = new String[3][2];

        for (int i = 0; i < csvReport.length; i++) {
            String csvRecord = csvReport[i];
            String[] tokens = csvRecord.split(",");
            String depName = tokens[1];
            double salary = Double.parseDouble(tokens[2]);

            //..

        }


    }


}
