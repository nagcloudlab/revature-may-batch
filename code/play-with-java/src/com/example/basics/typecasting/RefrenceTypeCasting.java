package com.example.basics.typecasting;

interface Vehicle {
    int ride(int speed);
}

class Car implements Vehicle {
    public int ride(int speed) {
        return 200;
    }

    public void playMedia() {
        System.out.println("play-media");
    }
}

class Bike implements Vehicle {
    public int ride(int speed) {
        return 100;
    }
}

class Cycle implements Vehicle {

    @Override
    public int ride(int speed) {
        return 0;
    }
}


//"Open For Extension , Closed for Modification"  with this principle, object become polymorphic
class Rider {

//    public void doRideCar(Car car) {
//        car.playMedia();
//        car.ride(100);
//    }
//
//    public void doRideBike(Bike bike) {
//        bike.ride(100);
//    }

    public void doRide(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            car.playMedia();
        }
        vehicle.ride(100);
    }

}


class ReferenceTypeCasting {
    public static void main(String[] args) {

//        Vehicle vehicle = null;
//        vehicle = new Car(); // implicit casting  aka up-casting aka generalization
//        vehicle.ride(100);
//
//        vehicle=new Bike();
//
//        if(vehicle instanceof Car) {
//            Car car = (Car) vehicle; // explicit casting aka down-casting aka specialization
//            car.playMedia();
//        }else{
//            System.out.println("invalid casting");
//        }


        Car car = new Car();
        Bike bike = new Bike();

        Rider rider = new Rider();
        rider.doRide(car);
        rider.doRide(bike);
        rider.doRide(new Cycle());


    }
}
