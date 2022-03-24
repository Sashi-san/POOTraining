package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Animalerie {

    private static final int NB_CAGES = 10;
    private List<Cage> cages;
    private List<Class> registre;

    public Animalerie() {
        cages = new ArrayList<>();
        registre = new ArrayList<>();
        initCages();
//        feedRoutine();
    }

    private void initCages() {
        for (int i = 0; i < NB_CAGES; i++) {
            cages.add(new Cage());
        }
    }

    public void deposerAnimal(Enfermable enfermable) {
        for (Cage cage : cages) {
            if (cage.estVide()) {
                cage.enfermer(enfermable);
                enregistrerAnimal(enfermable);
                break;
            }
        }
    }

    private void enregistrerAnimal(Enfermable enfermable) {
        if (!registre.contains(enfermable.getClass())) {
            registre.add(enfermable.getClass());
        }
    }

    public void descenteDeFlics() {
        boolean infraction = false;
        System.err.println("Controle des cages s'il vous plait !");
        for (Cage cage : cages) {
            Enfermable contenuDeLaCage = cage.consulterContenu();
            if (contenuDeLaCage instanceof Chien) {
                System.err.println("Un chien par ici !");
            } else if (contenuDeLaCage instanceof Tortue) {
                System.err.println("Une petite tortue...");
            } else if (contenuDeLaCage instanceof Enfant) {
                System.err.println("Mais ! C'est quoi ça ?!");
                infraction = true;
            }
        }
        if (infraction) {
            System.err.println("Nous avons trouvé des enfants à l'arrière... les mains sur la tête !");
        } else {
            System.err.println("Rien à signaler.");
        }
    }

    private void nourrirAnimal(Cage c) {
        System.err.println("On nourrit " + c.consulterContenu().getNom());
        c.nourrir();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }

    private void feedRoutine() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (Cage cage : cages) {
                        if (!cage.estVide()) {
                            nourrirAnimal(cage);
                        }
                    }
                    try { Thread.sleep(10000); } catch (InterruptedException e) {}
                }
            }
        });
    }
}
