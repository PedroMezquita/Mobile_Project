//package fr.iuttest.jeuandroid.model.attack;
//
//import model.Manager;
//import model.entities.Personnage;
//import model.maps.Map;
//
//import java.util.ArrayList;
//
//public class DammagerSimpleEnnemi implements DamagerEnnemi{
//
//
//
//    @Override
//    public void personnageHit(Attack atk, ArrayList<Personnage> personnage, Map map) {
//        for (Personnage pers : personnage) {
//            pers.setCurrentHP(pers.getCurrentHP() - atk.getDegat());
//            atk.setLifeTime(1);
//            if (pers.getCurrentHP() <= 0) {
//                map.removeEntity(pers);
//            }
//        }
//    }
//}
