package fr.iuttest.jeuandroid.model.jeu.entities;

import java.io.Serializable;

//classe métier Joueur
public class Joueur extends Personnage implements Serializable {

    //Nom du personnage
    private String name;

    public Joueur(int atkPnt, int maxHP, int currentHP, int speed, String name, int xsize, int ysize, int xpos, int ypos, String id, int redColor, int greenColor, int blueColor) {
        super(atkPnt, maxHP, currentHP, speed, xsize, ysize, xpos, ypos, id, redColor, greenColor, blueColor);
        this.name = name;
    }

    @Override
    public String toString() {
        return "nom : "+name+", "+super.toString();
    }

    public String getName() {
        return name;
    }

    public void setX(int x){ getPos().setxPos(x); }
    public int getX(){return getPos().getxPos();}

    public void setY(int y){ getPos().setyPos(y); }
    public int getY(){return getPos().getyPos();}
}
