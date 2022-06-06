package com.example.collections;

import java.util.HashMap;
import java.util.Map;

public class Ex2 {
    public static void main(String[] args) {

        String[] csvData = new String[]{
                "A1,IT,1000.00",
                "A2,HR,1000.00",
                "A3,IT,1000.00",
                "A4,IT,1000.00",
                "A5,SALES,1000.00",
                "A6,IT,1000.00",
        };

        Map<String, Double> summary = new HashMap<>();

        for (String csvRecord : csvData) {
            String[] tokens = csvRecord.split(",");
            String depName = tokens[1];
            double salary = Double.parseDouble(tokens[2]);
            if (!summary.containsKey(depName)) {
                summary.put(depName, salary);
            } else {
                double newSalary = summary.get(depName) + salary;
                summary.put(depName, newSalary);
            }
        }
        System.out.println(summary.size());
        for (String depName : summary.keySet()) {
            System.out.println(depName + ":" + summary.get(depName));
        }
        for (double sal : summary.values()) {
            System.out.println(sal);
        }

    }
}
