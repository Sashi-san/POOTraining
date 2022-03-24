package com.company;

public class Tortue extends Animal{
    public Tortue() {
        super("Franklin");
    }

    public Tortue(String name) {
        super(name);
    }

    @Override
    public void shout() {
        if (age < 5) {
            System.err.println(name + " : Han...");
        } else {
            System.err.println(name + " : HAAAN !");
        }
    }
}
