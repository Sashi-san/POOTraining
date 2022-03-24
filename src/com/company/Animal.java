package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Animal implements Enfermable {
    protected String name;
    protected int age;
    protected int hunger;
    protected boolean isAlive;

    public Animal(String name) {
        this.name = name;
        age = 0;
        hunger = 100;
        isAlive = true;
//        growRoutine();
//        hungerRoutine();
    }

    @Override
    public void comportementEnfermer() {
        shout();
    }

    @Override
    public void comportementSecouer() {
        shout();
    }

    @Override
    public void comportementNourriture() {
        manger();
    }

    @Override
    public String getNom() {
        return name;
    }

    public abstract void shout();

    private void growRoutine() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(new Runnable() {
            @Override
            public void run() {
                while (isAlive) {
                    age++;
                    System.err.println(name + " a maintenant " + age + " ans !");
                    try { Thread.sleep(20000); } catch (InterruptedException e) {}
                }
            }
        });
    }

    private void hungerRoutine() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(new Runnable() {
            @Override
            public void run() {
                while (isAlive) {
                    hunger -= 10;
                    if (hunger <= 0) {
                        System.err.println(name + " est mort. Tu devrais avoir honte...");
                        isAlive = false;
                    } else if (hunger <= 50) {
                        System.err.println(name + " a la dalle ! Il faut le nourrir !");
                    }
                    try { Thread.sleep(3000); } catch (InterruptedException e) {}
                }
            }
        });
    }

    public void manger() {
        hunger += 50;
        hunger = Math.min(hunger, 100);
    }

}
