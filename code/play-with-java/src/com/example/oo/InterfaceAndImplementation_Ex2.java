package com.example.oo;


//----------------------------------------------------------
// Wheel community
//----------------------------------------------------------
interface Wheel {
    // constant state
    public static final int SIZE = 5;

    // abstract behav
    public abstract int rotate(int speed);
}

//----------------------------------------------------------
// MRF Wheel
//----------------------------------------------------------

class MRFWheel implements Wheel {
    public int rotate(int speed) {
        System.out.println("MRF-wheel rotating..");
        return 100;
    }
}

//----------------------------------------------------------
// CEAT Wheel
//----------------------------------------------------------

abstract class CEATWheel implements Wheel {
    void commonWheelMethod() {
    }
}

class CEATCarWheel extends CEATWheel {
    public int rotate(int speed) {
        System.out.println("CEAT-car-wheel rotating..");
        return 200;
    }
}

class CEATBikeWheel extends CEATWheel {
    public int rotate(int speed) {
        System.out.println("CEAT-bike-wheel rotating..");
        return 500;
    }
}

//----------------------------------------------------------
// Toyota Car
//----------------------------------------------------------

class ToyotaCar {
    Wheel wheel;
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
    public void move() {
        this.wheel.rotate(80);
        System.out.println("Toyota-car moving");
    }
}


public class InterfaceAndImplementation_Ex2 {
    public static void main(String[] args) {


        ToyotaCar toyotaCar = new ToyotaCar();
        toyotaCar.setWheel(new MRFWheel());

        toyotaCar.move();
        toyotaCar.move();

        toyotaCar.setWheel(new CEATCarWheel());

        toyotaCar.move();
        toyotaCar.move();


    }
}

