package fr.iuttest.jeuandroid.model.jeu.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.Observer;

import fr.iuttest.jeuandroid.model.jeu.PlayerObserver;

//classe métier Joueur
public class Joueur extends Personnage implements Parcelable {

    //Nom du personnage
    private String name;

    private List<PlayerObserver> listObservateur;

    public Joueur(int atkPnt, int maxHP, int currentHP, int speed, String name, int xsize, int ysize, int xpos, int ypos, String id, int redColor, int greenColor, int blueColor) {
        super(atkPnt, maxHP, currentHP, speed, xsize, ysize, xpos, ypos, id, redColor, greenColor, blueColor);
        this.name = name;
        listObservateur = null;
    }

    @Override
    public String toString() {
        return "nom : "+name+", "+super.toString();
    }

    public String getName() {
        return name;
    }

    private void notifie(){
        for (PlayerObserver obs: listObservateur) {
            obs.updatePlayer();
        }
    }

    public List<PlayerObserver> getListObservateur() {
        return listObservateur;
    }

    public void addObserver(PlayerObserver obs){
        listObservateur.add(obs);
    }

    public void setX(int x){
        getPos().setxPos(x);
        notifie();
    }

    public void setY(int y){
        getPos().setyPos(y);
        notifie();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getPos().getxPos());
    }
}
