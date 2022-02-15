package fr.iuttest.jeuandroid.model.jeu.collisions;

import fr.iuttest.jeuandroid.model.jeu.attack.Attack;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

//interface de test de collisions des attaques
public interface CollisioneurAttaque {
    //test si une attaque touche
    void hitTest(Attack atk, Map map);
}
