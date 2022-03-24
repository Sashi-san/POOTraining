package com.company;

import java.util.Scanner;

public class MonAnimalerie {

    private boolean finDuProgramme;
    private Animalerie animalerie;
    private int menuCourant;
    private boolean nsfw = false;

    public MonAnimalerie() {
        menuCourant = 1;
        finDuProgramme = false;
        animalerie = new Animalerie();
    }

    private int recupererChoixUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private String recupererNomAnimal() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void deposerAnimal() {
        System.out.println("Quel animal ?");
        System.out.println("1 - Chien");
        System.out.println("2 - Chat");
        System.out.println("3 - Tortue");
        System.out.println("4 - Retour");
        int choix = recupererChoixUtilisateur();
        String nom = "";
        if (choix != 4) {
            System.out.println("Quel est le nom de l'animal ?");
            nom = recupererNomAnimal();
        }
        switch (choix) {
            case 1:
                animalerie.deposerAnimal(new Chien(nom));
                break;
            case 2:
                animalerie.deposerAnimal(new Chat(nom));
                break;
            case 3:
                animalerie.deposerAnimal(new Tortue(nom));
                break;
            case 5:
                animalerie.deposerAnimal(new Enfant(nom));
                break;
        }

    }

    public void bienvenue() {
        System.out.println("Bienvenue à l'animalerie !");
        System.out.println("1 - Déposer un animal");
        System.out.println("2 - Quitter");
        int choix = recupererChoixUtilisateur();
        switch (choix) {
            case 1:
                deposerAnimal();
                break;
            case 2:
                finDuProgramme = true;
                break;
        }

    }

    public void start() {
        while (!finDuProgramme) {
            switch (menuCourant) {
                case 1:
                    menuPrincipal();
                    break;
                case 2:
                    menuJouer();
                    break;
                case 3:
                    menuOption();
                    break;
            }
        }
    }

    private void menuPrincipal() {
        System.out.println("---------------- TITRE -----------------");
        System.out.println("1 - Jouer");
        System.out.println("2 - Options");
        System.out.println("3 - Quitter");
        int choix = recupererChoixUtilisateur();
        switch (choix) {
            case 1:
                menuCourant = 2;
                break;
            case 2:
                menuCourant = 3;
                break;
            case 3:
                finDuProgramme = true;
                break;
        }
    }

    private void menuJouer() {
        System.out.println("---------------- JEU -----------------");
        if (!nsfw) {
            System.out.println("Choix enfant désactivé");
        } else {
            System.out.println("Choix enfant activé");
        }

        System.out.println("1 - Retour");
        int choix = recupererChoixUtilisateur();
        switch (choix) {
            case 1:
                menuCourant = 1;
                break;
        }

    }

    private void menuOption() {
        System.out.println("---------------- OPTIONS -----------------");
        if (!nsfw) {
            System.out.println("1 - Apparaitre choix enfant (NSFW)");
        } else {
            System.out.println("1 - Cacher choix enfant (SFW)");
        }
        System.out.println("2 - Retour");
        int choix = recupererChoixUtilisateur();
        switch (choix) {
            case 1:
                nsfw = !nsfw;
                break;
            case 2:
                menuCourant = 1;
                break;
        }
    }
}
