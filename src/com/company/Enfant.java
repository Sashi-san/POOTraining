package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Enfant implements Enfermable {

    private String name;
    private int hunger;
    private boolean isAlive;

    public Enfant() {
        name = "Danny";
        hunger = 100;
        isAlive = true;
        hungerRoutine();
    }

    public Enfant(String name) {
        this.name = name;
        hunger = 100;
        isAlive = true;
        hungerRoutine();
    }

    public void appelAide() {
        System.err.println(name + " : Aidez moi !");
    }

    public void insulte() {
        System.err.println(name + " : Ta soeur elle boit l'eau des pates !");
    }

    @Override
    public void comportementEnfermer() {
        appelAide();
    }

    @Override
    public void comportementSecouer() {
        insulte();
    }

    @Override
    public void comportementNourriture() {
        manger();
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

    @Override
    public String getNom() {
        return name;
    }

    public void manger() {
        hunger += 50;
        hunger = Math.min(hunger, 100);
    }
}
