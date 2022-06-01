package com.example.collections;

import com.example.collections.model.Employee;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetColln_Ex1 {
    public static void main(String[] args) {

        Employee employee1 = new Employee(2313, "Tom", 1000.00);
        Employee employee2 = new Employee(4355, "Jerry", 2000.00);
        Employee employee3 = new Employee(4566, "Nag", 1000.00);
        Employee employee4 = new Employee(1234, "Indu", 3000.00);

        Set<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        for (Employee employee : employees) {
            System.out.println(employee);
        }


    }
}
