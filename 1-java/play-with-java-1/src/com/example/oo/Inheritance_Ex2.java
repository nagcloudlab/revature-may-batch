package com.example.oo;

//
// how to re-use obj's behavior through inheritance

// Author : Nag
abstract class LivingThing {

    public void eat() {
        System.out.println("LT-eat()");
    }

    public final void sleep() {
        System.out.println("LT-sleep()");
    }

    public abstract void work();

}

// Team-A
abstract class Human extends LivingThing {
    public void study() {
        System.out.println("Human:study()");
    }
}

class MaleHuman extends Human {
    public void work() {
        System.out.println("Male-Human-work()");
    }
}

class FemaleHuman extends Human {
    public void work() {
        System.out.println("FeMale-Human-work()");
    }
}

// Team-B
class Animal extends LivingThing {
    public void work() {
        System.out.println("Animal-work()");
    }
}

//Team-C
class Robot extends LivingThing {
    public void eat() {
        System.out.println("Robot-eat()");
    }

    public void work() {
        System.out.println("Robot-work()");
    }
}


class God {

//    public void manageHuman(Human human) {
//        human.eat();
//        human.sleep();
//        human.study();
//        human.work();
//    }

//    public void manageAnimal(Animal animal) {
//        animal.eat();
//        animal.sleep();
//        animal.work();
//    }

    public void manageLT(LivingThing lt) {
        lt.eat();
        lt.sleep();
        if (lt instanceof Human) {
            Human human = (Human) lt;
            human.study();
        }
        lt.work();
    }

}


public class Inheritance_Ex2 {
    public static void main(String[] args) {

        God god = new God();

//        LivingThing livingThing = new LivingThing();
        Human human = new MaleHuman();
        Animal animal = new Animal();
        Robot robot = new Robot();

        god.manageLT(human);
        System.out.println();
        god.manageLT(animal);
        System.out.println();
        god.manageLT(robot);


    }
}
