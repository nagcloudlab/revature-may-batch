package com.example.collections;

import com.example.collections.model.Car;
import com.example.collections.model.Owner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapColl_Ex1 {

    public static void main(String[] args) {

        //-------------------------------------------------------

        Owner owner1 = new Owner("Nag");
        Owner owner2 = new Owner("Riya");

        Car car1 = new Car("hundai-creta", "black");
        Car car2 = new Car("toy-car", "red");

        //-------------------------------------------------------
        Map<Owner, Car> carData = new HashMap<Owner, Car>();
        carData.put(owner1, car1);
        carData.put(owner2, car2);
        //-------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Owner Name?");
        String ownerName = scanner.nextLine();

        Owner key = new Owner(ownerName);
        Car car = carData.get(key);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("no car exist");
        }

        //-------------------------------------------------------------------

    }

}
