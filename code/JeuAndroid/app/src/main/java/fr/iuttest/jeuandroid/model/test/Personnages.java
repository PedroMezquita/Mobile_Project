package fr.iuttest.jeuandroid.model.test;

import java.util.ArrayList;
import java.util.List;

import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;

public class Personnages {

    private List<Joueur> listPerso;

    public Personnages() {
        listPerso = new ArrayList<Joueur>(){};
    }

    public void addPerso(Joueur perso){
        listPerso.add(perso);
    }

    public List<Joueur> getListPerso() {
        return listPerso;
    }
}
