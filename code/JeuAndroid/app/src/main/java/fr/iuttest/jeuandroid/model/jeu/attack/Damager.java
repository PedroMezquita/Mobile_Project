package fr.iuttest.jeuandroid.model.jeu.attack;



import java.util.ArrayList;

import fr.iuttest.jeuandroid.model.jeu.entities.Ennemi;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

//interface de calcule des dégats des attaques du joueur
public interface Damager {

    //inflige les dégats de l'attaque à partir de l'attaque, d'une liste d'enemis touchés et les supprimes de la carte en cas de mort
    void enemiHit(Attack atk, ArrayList<Ennemi> hits, Map map);

}
