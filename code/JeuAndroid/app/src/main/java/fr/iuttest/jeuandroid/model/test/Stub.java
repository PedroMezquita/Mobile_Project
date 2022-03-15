package fr.iuttest.jeuandroid.model.test;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.entities.*;

import java.util.ArrayList;

public class Stub {

    public static Personnages create(){
        Personnages listePerso = new Personnages();

        Joueur joueur = new Joueur(2,2,3,3,"Bob",1,1,2,2,"2",2,2,3);
        joueur.setSprite(R.drawable.template_character);
        listePerso.addPerso(joueur);
        Joueur joueur2 = new Joueur(6,2,2,3,"Joseph",1,1,2,2,"2",2,2,3);
        joueur2.setSprite(R.drawable.template_character);
        listePerso.addPerso(joueur2);
        Joueur joueur3 = new Joueur(6,2,2,3,"Pedro",1,1,2,2,"2",2,2,3);
        joueur3.setSprite(R.drawable.template_character);
        listePerso.addPerso(joueur3);
        Joueur joueur4 = new Joueur(6,2,2,3,"Jules",1,1,2,2,"2",2,2,3);
        joueur4.setSprite(R.drawable.template_character);
        listePerso.addPerso(joueur4);

        return listePerso;
    }
}
