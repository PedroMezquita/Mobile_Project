package fr.iuttest.jeuandroid.model.jeu;

//import model.Direction;
//import model.entities.Personnage;
//import model.maps.Map;

import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

//interface qui définie la méthode de déplacement des ennemis
public interface IA {
    //déplace un ennemi en direction du joueur et retourne la direction choisie
    Direction approcheJoueur(Personnage joueur, Personnage enemi, Map map);
}
