package com.example.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

class Insurance {
    private String name;

    public Insurance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Car {
    Optional<Insurance> insurance = Optional.empty();

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Person {
    Optional<Car> car = Optional.empty();

    public Optional<Car> getCar() {
        return car;
    }
}

public class Optional_Ex {
    public static void main(String[] args) {

        Insurance insurance = new Insurance("xyz-insurance");
        Car car = new Car();
        car.insurance = Optional.of(insurance);
        Person person = new Person();
        person.car = Optional.of(car);

        String insuranceName = getCarInsuranceName(Optional.of(person));
        System.out.println(insuranceName);


        int[] arr=new int[]{1,2,3,4,5};
        // fins Max from given numbers

        OptionalInt optionalInt=Arrays.stream(arr)
                .max();

        int max=optionalInt
                .orElseGet(()->0);
        System.out.println(max);
    }

    private static String getCarInsuranceName(Optional<Person> person) {
        return
                person
                        .flatMap(Person::getCar)
                        .flatMap(Car::getInsurance)
                        .map(Insurance::getName)
                        .orElse("Unknown");
    }
}
