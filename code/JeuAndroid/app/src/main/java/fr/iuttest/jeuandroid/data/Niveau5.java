package fr.iuttest.jeuandroid.data;


import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.attack.AttackPattern;
import fr.iuttest.jeuandroid.model.jeu.entities.Ennemi;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.model.jeu.entities.Props;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

public class Niveau5 extends Niveau{

    @Override
    public Map load() {
        Map map = new Map();
        Props obstacle1 = new Props(500,10,0,0,"Mur haut");
        obstacle1.setRGB(0,0,0);
        obstacle1.setSprite(R.drawable.template_wall);
        map.addEntity(obstacle1);
        Props obstacle2 = new Props(10,500,490,0,"Mur droite");
        obstacle2.setRGB(0,0,0);
        obstacle2.setSprite(R.drawable.template_wall);
        map.addEntity(obstacle2);
        Props obstacle3 = new Props(500,10,0,490,"Mur bas");
        obstacle3.setRGB(0,0,0);
        obstacle3.setSprite(R.drawable.template_wall);
        map.addEntity(obstacle3);
        Props obstacle4 = new Props(10,500,0,0,"Mur gache");
        obstacle4.setRGB(0,0,0);
        obstacle4.setSprite(R.drawable.template_wall);
        map.addEntity(obstacle4);
//        Personnage joueur = new Joueur(100,1,1,5,"mec", /* 21*/ 41, /* 21*/41,20,20,"joueur", 1,0,0); //Le joueur charge avant les props
//        joueur.setSprite(R.drawable.template_character);
//        AttackPattern atqJoueur = new AttackPattern(50, 100, 250, 250, "megaBoule", 250);
//        atqJoueur.setRGB(1,0.5,0);
//        joueur.setAttaque(atqJoueur);
//        map.addEntity(joueur);
        Ennemi ennemi = new Ennemi(10,100,100,3, 100, 100, 200, 350, "ennemi1", 1,1,0);
        ennemi.setSprite(R.drawable.template_ennemi);
        AttackPattern atqEnemi = new AttackPattern(30,10,10,10,"slime",3);
        atqEnemi.setRGB(0,1,0);
        ennemi.setAttaque(atqEnemi);
        map.addEnemy(ennemi);
        map.setImage(R.drawable.template_background);
        return map;
    }
}
