package com.company;

public class Cage {
    private Enfermable contenu;

    public Cage() {
        contenu = null;
    }

    public void enfermer(Enfermable object) {
        this.contenu = object;
        this.contenu.comportementEnfermer();
    }

    public void secouer() {
        if (contenu != null) {
            contenu.comportementSecouer();
        }
    }

    public void nourrir() {
        contenu.comportementNourriture();
    }

    public boolean estVide() {
        return contenu == null;
    }

    public Enfermable consulterContenu() {
        return contenu;
    }
}
