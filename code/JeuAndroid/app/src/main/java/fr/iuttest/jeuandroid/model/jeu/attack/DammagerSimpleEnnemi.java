package fr.iuttest.jeuandroid.model.jeu.attack;


import java.util.ArrayList;

import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

public class DammagerSimpleEnnemi implements DamagerEnnemi{



    @Override
    public void personnageHit(Attack atk, ArrayList<Personnage> personnage, Map map) {
        for (Personnage pers : personnage) {
            pers.setCurrentHP(pers.getCurrentHP() - atk.getDegat());
            atk.setLifeTime(1);
            if (pers.getCurrentHP() <= 0) {
                map.removeEntity(pers);
            }
        }
    }
}
