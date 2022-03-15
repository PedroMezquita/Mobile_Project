package fr.iuttest.jeuandroid.model.jeu;

import android.widget.ImageView;

import java.util.ArrayList;

import fr.iuttest.jeuandroid.model.jeu.collisions.CollisioneurCarre;
import fr.iuttest.jeuandroid.model.jeu.deplacement.DeplacerBasique;
import fr.iuttest.jeuandroid.model.jeu.deplacement.Deplaceur;

//boucle selon un timer afin de faire des évenements régulier
public class Loop extends Thread{

    //timer de la boucle
    int timer;
    //JUSTE POUR DU TEST, A CHANGER LE PLUS TOT POSSIBLE ------------------------------------------------------------------------------------------------------------------
    ImageView enemi;
    ImageView perso;
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------



    //liste des observeurs à notifier
    private ArrayList<Observer> listeObs = new ArrayList<Observer>();

    public Loop (int timer, ImageView ennemi, ImageView perso){
        this.timer = timer;
        this.enemi = ennemi;
        this.perso = perso;
    }

    public Loop(int timer){
        this.timer = timer;
    }

    //ajoute un observeur à la liste
    public void attacher (Observer obs){ listeObs.add(obs); }

    //retire un observeur de la liste
    public void detacher (Observer obs){
        listeObs.remove(obs);
    }


    //boucle et appelle beep
    @Override
    public void run() {
        while(true) { //ça marche a moitie, on peux faire mieux mais pour l'instant ça fait un peu la tache
            try {
                sleep(timer);
                beep();
            } catch (InterruptedException e) {
                break;
            }

        }
    }

    //notifie tout les observeurs
    public void beep() {
        for (Observer obs: listeObs) {
            obs.update();
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<Observer> getListeObs() {
        return (ArrayList<Observer>) listeObs.clone();
    }
}
