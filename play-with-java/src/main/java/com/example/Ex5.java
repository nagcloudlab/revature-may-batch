package com.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class Person {

    public final String name;
    public final int age;
    public final List<String> skills;

    public Person(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = List.copyOf(skills);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", skills=" + skills +
                '}';
    }


}

public class Ex5 {

    public static void main(String[] args) {

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("javascript");

        Person p = new Person("Nag", 39, skills);


    }
}
