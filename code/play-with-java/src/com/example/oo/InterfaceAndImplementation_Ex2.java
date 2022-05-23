package com.example.oo;


interface USB {
    byte[] read();

    void write(byte[] data);
}

class Mobile implements USB {
    public byte[] read() {
        //..
        System.out.println("Mobile : read()");
        return new byte[0];
    }

    public void write(byte[] data) {
        System.out.println("Mobile : write()");
        //..
    }
}

class Camera implements USB {

    public byte[] read() {
        System.out.println("Camera : read()");
        return new byte[0];
    }

    public void write(byte[] data) {
        System.out.println("Camera : write()");
    }
}

class Laptop {
    public void readExternalDevice(USB usb) {
        usb.read();
    }

    public void writeExternalDevice(USB usb) {
        usb.write(null);
    }
}

public class InterfaceAndImplementation_Ex2 {

    public static void main(String[] args) {

        Laptop laptop = new Laptop();
        Mobile mobile = new Mobile();
        Camera camera = new Camera();
        laptop.readExternalDevice(mobile);
        laptop.writeExternalDevice(camera);

    }

}
