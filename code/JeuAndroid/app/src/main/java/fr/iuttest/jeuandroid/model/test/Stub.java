package fr.iuttest.jeuandroid.model.test;

import java.util.ArrayList;

public class Stub {

    public static Personnages create(){
        Personnages listePerso = new Personnages();

        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));
        listePerso.addPerso(new Personnage("Bob"));

        return listePerso;
    }
}
