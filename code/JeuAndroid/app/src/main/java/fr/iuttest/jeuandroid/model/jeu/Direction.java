package fr.iuttest.jeuandroid.model.jeu;

//classe métier direction
public class Direction {
    //direction horizontale
    private int xDir;
    //direction verticale
    private int yDir;

    public Direction(int xDir, int yDir){
        if (xDir < -1 || xDir > 1 || yDir < -1 || yDir > 1)
            throw (new IllegalArgumentException());
        else{
            this.xDir = xDir;
            this.yDir = yDir;
        }
    }

    public int getxDir() {
        return xDir;
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }



}
/*
Nouvelle classe

Explication:
    Ceci est une direction
    Elle represente la direction dans une grille 1,1
    Exemple:

        -1,1   (y)    1,1
           \   0,1   /
            \   |   /
              \ | /
     -1,0 ------0------ 1,0 (x)
              / | \
            /   |   \
          /    0,-1   \
        -1,-1         1,-1


    Ceci nous donne une possibilité de 8 directions facilement detectables


 */