package fr.iuttest.jeuandroid.model.jeu.attack;

import fr.iuttest.jeuandroid.model.jeu.Direction;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;

//interface de création d'une attaque
public interface Attacker {
    //créer uine attaque à partir d'un personnage et d'une direction
    Attack attack(Personnage pers, Direction dir); //attaque à rajouter quand fait
}
