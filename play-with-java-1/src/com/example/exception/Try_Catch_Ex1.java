package com.example.exception;

class Employee {
    public void doWork() {
        System.out.println("emp working");
    }
}

public class Try_Catch_Ex1 {

    public static void main(String[] args) {
        System.out.println("A");
        try {
            System.out.println("B");
            int div = 1 / 1;
            int[] numbers = {10, 20};
            System.out.println(numbers[1]);
            Employee employee = new Employee();
            employee.doWork();
            System.out.println("C");
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("D1");
            System.out.println("Ex-" + e.getMessage());
        } catch (Exception e) {
            System.out.println("D3");
            System.out.println("Ex-" + e.getMessage());
        }
        System.out.println("E");
    }

}
