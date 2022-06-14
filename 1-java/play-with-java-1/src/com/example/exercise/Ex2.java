package com.example.exercise;

import java.util.HashMap;
import java.util.Map;


public class Ex2 {

    public static void main(String[] args) {
        /*
            format => name,dep,salary
            dep = IT | HR | SALES
         */
        // input
        String[] csvReport = {
                "A,IT,1000.00",
                "B,IT,2000.00",
                "C,HR,4000.00",
        };
        // output
        /*
        calculate total salary of known departments
            IT - 3000
            HR - 8000
            SALES - 4000
         */

        Map<String, Double> hashMap = new HashMap<String, Double>();

        for (String csvRecord : csvReport) {
            String[] tokens = csvRecord.split(",");

            String depName = tokens[1];
            double salary = Double.parseDouble(tokens[2]);

            if (hashMap.containsKey(depName)) {
                double newSalary = hashMap.get(depName) + salary;
                hashMap.put(depName, newSalary);
            } else {
                hashMap.put(depName, salary);
            }
        }

        System.out.println(hashMap);

    }


}


