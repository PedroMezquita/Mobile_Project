package fr.iuttest.jeuandroid.data;


import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.attack.AttackPattern;
import fr.iuttest.jeuandroid.model.jeu.entities.Ennemi;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.model.jeu.entities.Props;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

public class Niveau1 extends Niveau{

    @Override
    public Map load() {
        Map map = new Map();
        //changer les id
        Props obstacle1 = new Props(100,500,600,700,"Mur haut");
        obstacle1.setRGB(0,0,0);
        obstacle1.setSprite(R.drawable.template_wall);
        map.addEntity(obstacle1);
        Props obstacle2 = new Props(500,100,490,110,"Mur droite");
        obstacle2.setRGB(0,0,0);
        obstacle2.setSprite(R.drawable.template_wall);
        map.addEntity(obstacle2);
        Props obstacle3 = new Props(100,500,660,490,"Mur bas");
        obstacle3.setRGB(0,0,0);
        obstacle3.setSprite(R.drawable.template_wall);
        map.addEntity(obstacle3);
        Props obstacle4 = new Props(500,100,90,100,"Mur gache");
        obstacle4.setRGB(0,0,0);
        obstacle4.setSprite(R.drawable.template_wall);
        map.addEntity(obstacle4);
//        Personnage joueur = new Joueur(1,10,10,5,"mec", /* 21*/ 201, /* 21*/201,20,20,"joueur", 1,0,0); //Le joueur charge avant les props
//        joueur.setSprite(R.drawable.template_character);
        AttackPattern atqJoueur = new AttackPattern(25, 2, 10, 25, "trait", 50);
        atqJoueur.setRGB(0.5,0.5,1);
        //        joueur.setAttaque(atqJoueur);
//        map.addEntity(joueur);
        Ennemi ennemi = new Ennemi(1,1,1,5, 55, 55, 250, 400, "ennemi1", 1,1,0);
        ennemi.setSprite(R.drawable.template_ennemi);
        AttackPattern atqEnemi = new AttackPattern(20,1,55,55,"slime",5);
        atqEnemi.setRGB(0,1,0);
        ennemi.setAttaque(atqEnemi);
        map.addEnemy(ennemi);
        map.setImage(R.drawable.template_background);
        return map;
    }
}
