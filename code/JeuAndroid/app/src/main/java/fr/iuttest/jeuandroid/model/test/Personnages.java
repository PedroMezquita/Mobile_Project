package fr.iuttest.jeuandroid.model.test;

import java.util.ArrayList;
import java.util.List;

public class Personnages {

    private List<Personnage> listPerso;

    public Personnages() {
        listPerso = new ArrayList<Personnage>(){};
    }

    public void addPerso(Personnage perso){
        listPerso.add(perso);
    }

    public List<Personnage> getListPerso() {
        return listPerso;
    }
}
