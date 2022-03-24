package com.company;

public class OeufDeTortue {
   private int nbDeCouvage =0;

    public OeufDeTortue(){
    }
    public void couver() throws InterruptedException {
        this.nbDeCouvage++;
        if (nbDeCouvage >=5){
            Tortue tama = new Tortue();
        }

    }
}
