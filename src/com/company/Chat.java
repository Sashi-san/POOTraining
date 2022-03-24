package com.company;

public class Chat extends Animal{

    public Chat() {
        super("Felix");
    }

    public Chat(String name) {
        super(name);
    }

    @Override
    public void shout() {
        System.err.println(name + " : Miaou !");
    }
}
