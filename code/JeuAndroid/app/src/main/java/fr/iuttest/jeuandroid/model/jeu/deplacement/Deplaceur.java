package fr.iuttest.jeuandroid.model.jeu.deplacement;

import fr.iuttest.jeuandroid.model.jeu.Direction;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;

//
//
//import model.Direction;
//import model.entities.Personnage;
//
//interface pour les déplacement
public interface Deplaceur {

    //déplace un personnage dans une direction
    void deplacer(Personnage pers, Direction dir);

}


