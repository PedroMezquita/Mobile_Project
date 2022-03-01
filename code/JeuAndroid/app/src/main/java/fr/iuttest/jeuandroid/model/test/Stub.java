package fr.iuttest.jeuandroid.model.test;

import fr.iuttest.jeuandroid.model.jeu.entities.*;

import java.util.ArrayList;

public class Stub {

    public static Personnages create(){
        Personnages listePerso = new Personnages();

        listePerso.addPerso(new Joueur(2,2,3,3,"Bob",2,2,2,2,"2",2,2,3));
        listePerso.addPerso(new Joueur(6,2,2,3,"Joseph",2,2,2,2,"2",2,2,3));
        listePerso.addPerso(new Joueur(55,150,150,1,"Yohan",2,2,2,2,"2",2,2,3));
        listePerso.addPerso(new Joueur(4,2,3,3,"Bob",2,2,2,2,"2",2,2,3));

        return listePerso;
    }
}
