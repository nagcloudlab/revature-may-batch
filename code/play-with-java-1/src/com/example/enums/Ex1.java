package com.example.enums;

// a type holds set of related constants
enum Gender {
    MALE, FEMALE
}

class Employee {

    int id;
    String name;
    Gender gender;


}

public class Ex1 {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.id = 123;
        employee.name = "nag";
        employee.gender = Gender.MALE;

//        employee.gender = "abc";

    }

}
