package com.example.oo;

//
// how to re-use obj's behavior through inheritance

// Author : Nag
class LivingThing {

    public void eat() {
        System.out.println("LT-eat()");
    }

    public final void sleep() {
        System.out.println("LT-sleep()");
    }

    public void work() {
        System.out.println("LT-work()");
    }

}

// Team-A
class Human extends LivingThing {
    public void study() {
        System.out.println("Human:study()");
    }

    // overrding
    public void work() {
        System.out.println("Human:work()");
    }


}

// Team-B
class Animal extends LivingThing {
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
            Human human= (Human)lt;
            human.study();
        }
        lt.work();
    }

}


public class Inheritance_Ex2 {
    public static void main(String[] args) {

        God god = new God();

        Human human = new Human();
        Animal animal = new Animal();
        Robot robot = new Robot();

        god.manageLT(human);
        System.out.println();
        god.manageLT(animal);
        System.out.println();
        god.manageLT(robot);


    }
}
