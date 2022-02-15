package fr.iuttest.jeuandroid.model.jeu.attack;

import java.util.ArrayList;

import fr.iuttest.jeuandroid.model.jeu.entities.Ennemi;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

public class DamagerSimple implements Damager{


    @Override
    public void enemiHit(Attack atk, ArrayList<Ennemi> hits, Map map) {
        for (Ennemi enemy : hits) {
            enemy.setCurrentHP(enemy.getCurrentHP() - atk.getDegat());
            atk.setLifeTime(1);
            if (enemy.getCurrentHP() <= 0) {
                map.removeEnemy(enemy);
            }
        }
    }

}
