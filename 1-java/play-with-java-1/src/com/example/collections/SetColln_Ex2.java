package com.example.collections;

import com.example.collections.model.Person;

import java.util.HashSet;
import java.util.Set;

public class SetColln_Ex2 {

    public static void main(String[] args) {

        Set<Person> people = new HashSet<>(100);

        Person person1 = new Person(12, "Tom", "tom@mail.com", "india");
        Person person2 = new Person(13, "Tom", "tom@mail.com", "india");


        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        System.out.println(person1.equals(person2));

        boolean b1=people.add(person1);
        System.out.println(b1);
        boolean b2=people.add(person2);
        System.out.println(b2);


        System.out.println(people.size()); // how many elements are there
        System.out.println(people);

    }

}
