package com.example.oo;


interface Call{
    void makeCall();
}
interface Text{}
interface Media{}
interface Wifi{}
interface Blutooth{}
interface BlutoothTwoZero extends Blutooth{}
interface BlutoothTwoFive extends Blutooth{}
interface BasicPhone extends Call,Text,Media { }
interface SmartPhone extends Call,Text,Media,Wifi,Blutooth { }
interface AirDrop{}

abstract class AppleSmartDevice implements SmartPhone,BlutoothTwoFive { }

class Iphonee extends AppleSmartDevice implements AirDrop{
    public void makeCall() {
    }
}

public class ObjectDesign {

    public static void main(String[] args) {

    }

}
