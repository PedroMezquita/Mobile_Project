package fr.iuttest.jeuandroid.model.jeu.entities;

//import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;

//
//
//classe métier Ennemi
public class Ennemi extends Personnage {

    public Ennemi(int atkPnt, int maxHP, int currentHP, int speed, int xsize, int ysize, int xpos, int ypos, String id, int redColor, int greenColor, int blueColor) {
        super(atkPnt, maxHP, currentHP, speed, xsize, ysize, xpos, ypos, id, redColor, greenColor, blueColor);
    }

    public void setX(int x){ getPos().setxPos(x); }
    public int getX(){return getPos().getxPos();}

    public void setY(int y){ getPos().setyPos(y); }
    public int getY(){return getPos().getyPos();}
}
