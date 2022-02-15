package fr.iuttest.jeuandroid.model.jeu.attack;

import java.util.ArrayList;

import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

//interface de calcul des degats des attaques enemies
public interface DamagerEnnemi {
    //inflige les dégats de l'attaque à partir de l'attaque, d'une liste de personnages touchés et les supprimes de la carte en cas de mort
    void personnageHit(Attack atk, ArrayList<Personnage> personnage , Map map);
}
