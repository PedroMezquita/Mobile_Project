package fr.iuttest.jeuandroid.model.jeu.entities;


//classe métier Position qui représente la position d'une entité
public class Position {
    //position horizontale
    private int xPos;  //Trouver un equivalent des integer property
    //position verticale
    private int yPos;  //Trouver un equivalent des integer property

    public Position(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) { this.xPos = xPos;   }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
