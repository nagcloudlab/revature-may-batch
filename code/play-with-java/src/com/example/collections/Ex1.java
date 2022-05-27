package com.example.collections;

public class Ex1 {

    public static void main(String[] args) {

        LinkedList<String> students = new LinkedList<>();
        students.add("Alberto"); // 0
        students.add("Andrew"); // 1


        // iterate / traverse / loop
        for (int i = 0; i < students.size(); i++) {
            String name = students.get(i);
            System.out.println(name);
        }

    }

}
