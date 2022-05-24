package com.example.oo;

class Actor {
    public void act(int i) {
        System.out.println("Hero Act");
    }
    public void act(long l) {
        System.out.println("Villain Act");
    }
}


public class Polymorphism {

    public static void main(String[] args) {

        Actor actor = new Actor();
        actor.act(12);
        actor.act(12L);

    }

}
