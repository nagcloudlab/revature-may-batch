package com.example.oo;

//--------------------------------------------------------------------
// electronic
//--------------------------------------------------------------------

interface ElecDevice {
    void start();

    String read();

    void write(String data);

    void stop();
}

abstract class AbstractElecDevice implements ElecDevice {
    public void start() {
    }

    public void stop() {
    }
}

class Mobile extends AbstractElecDevice implements ElecDevice {
    public String read() {
        return null;
    }

    public void write(String data) {
    }
}

class Laptop extends AbstractElecDevice implements ElecDevice {
    public String read() {
        return null;
    }

    public void write(String data) {
    }
}

//--------------------------------------------------------------------
// Techie
//--------------------------------------------------------------------

class Techie {
    public void doStuff(ElecDevice elecDevice) {
        elecDevice.start();
        elecDevice.read();
        elecDevice.write("bla bla");
        elecDevice.stop();
    }
}

public class InterfaceVsAbstractClass_Ex2 {
    public static void main(String[] args) {

        Techie techie = new Techie();
        techie.doStuff(new Mobile());
        techie.doStuff(new Laptop());

    }
}
