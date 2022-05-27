package com.example.collections;

public class Ex1 {

    public static void main(String[] args) {

        LinkedList<String> students = new LinkedList<>();
        students.add("Alberto"); // 0
        students.add("Andrew"); // 1
        students.add("Benny"); // 2

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }


    }

}
