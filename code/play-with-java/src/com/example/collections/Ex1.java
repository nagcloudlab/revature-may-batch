package com.example.collections;

public class Ex1 {

    public static void main(String[] args) {

        LinkedList<String> students = new LinkedList<>();
        students.add("Alberto");
        students.add("Andrew");
        students.add("Benny");
        students.add(2, "Ben");

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        // Alb
//        And
// ben
//        Benny
    }

}
