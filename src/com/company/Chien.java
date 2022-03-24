package com.company;

public class Chien extends Animal {
    public Chien() {
        super("Medor");
    }

    public Chien(String name) {
        super(name);
    }

    @Override
    public void shout() {
        if (age < 2) {
            System.err.println(name + " : waf !");
        } else {
            System.err.println(name + " : WOOOF !");
        }
    }
}
