package com.example.oo;

class Speaker {
    int id;
    String name;

    // constructor - overloading
    Speaker(int id) {
        this.id = id;
    }

    Speaker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // method
    void doSpeak(String topic) {
        System.out.println(this.name + " quick intro " + topic);
    }

    void doSpeak(String topic, int duration) {
        System.out.println(this.name + " brief intro " + topic);
    }
}

class Training {
    void doTraining() {
        System.out.println("doTraining()");
    }
}

class ClassRoomTraining extends Training {
    void doTraining() {
        System.out.println("doTraining()");
    }
}

public class Overloading_vs_Overriding {

    public static void main(String[] args) {

        Speaker speaker = new Speaker(12, "Nag");
        speaker.doSpeak("topic", 10);

    }

}
