package fr.iuttest.jeuandroid.model.jeu.attack;


import fr.iuttest.jeuandroid.model.jeu.Direction;
import fr.iuttest.jeuandroid.model.jeu.entities.Position;

public class AtkDeplaceurSimple implements AtkDeplaceur{

    public void deplaceAttack(Attack atk){
        Direction dir = atk.getDir();
        Position oldPos = atk.getPos();
        if(dir.getyDir() == -1){
            atk.setPosition(oldPos.getxPos(), oldPos.getyPos()-10);
        }
        if(dir.getyDir() == 1){
            atk.setPosition(oldPos.getxPos(), oldPos.getyPos()+10);
        }
        if(dir.getxDir() == -1){
            atk.setPosition(oldPos.getxPos()-10, oldPos.getyPos());
        }
        if(dir.getxDir() == 1){
            atk.setPosition(oldPos.getxPos()+10, oldPos.getyPos());
        }
    }

}
