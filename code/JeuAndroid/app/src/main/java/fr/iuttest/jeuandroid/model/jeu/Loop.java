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

    //ajoute un observeur à la liste
    public void attacher (Observer obs){
        listeObs.add(obs);
    }

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
/* Code original
        for (Observer obs: listeObs) {
            obs.update();
        }

 */
        IA enemiIA = new IAPathfind();
//        Deplaceur deplace = new DeplacerBasique(new CollisioneurCarre(map));
//C'est degueulasse mais ça devrais marcher, a changer rapidement-------------------------------------------------------------------------------------------------
        if (enemi.getX() > perso.getX())
            enemi.setX(enemi.getX() - 2);
        else { enemi.setX(enemi.getX() + 2);}

        if (enemi.getY() > perso.getY())
            enemi.setY(enemi.getY() - 2);
        else { enemi.setY(enemi.getY() + 2);}
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<Observer> getListeObs() {
        return (ArrayList<Observer>) listeObs.clone();
    }
}
