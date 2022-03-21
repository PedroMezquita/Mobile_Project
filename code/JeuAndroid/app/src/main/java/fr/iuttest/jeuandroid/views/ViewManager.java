package fr.iuttest.jeuandroid.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Set;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.Direction;
import fr.iuttest.jeuandroid.model.jeu.Loop;
import fr.iuttest.jeuandroid.model.jeu.Observer;
import fr.iuttest.jeuandroid.model.jeu.PlayerObserver;
import fr.iuttest.jeuandroid.model.jeu.SoundManager;
import fr.iuttest.jeuandroid.model.jeu.attack.Attack;
import fr.iuttest.jeuandroid.model.jeu.attack.AttackPattern;
import fr.iuttest.jeuandroid.model.jeu.attack.BasiqueAttacker;
import fr.iuttest.jeuandroid.model.jeu.entities.Ennemi;
import fr.iuttest.jeuandroid.model.jeu.entities.Entite;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

public class ViewManager implements Observer {

    private Joueur joueur;
    private ImageView joueurView;

    private Ennemi ennemi;
    private ImageView ennemiView;
    private java.util.Map<Ennemi, ImageView> ennemiViews;
    private BasiqueAttacker attacker;
    private Activity parentActivity;

    private Ennemi firstEnemi;

    private FrameLayout layout_jeu;


    private Map map;

    private SoundManager sound1;
    private SoundManager sound2;
    private SoundManager sound3;
    private SoundManager sound4;
    private SoundManager sound5;

    private ArrayList<SoundManager> allSound;




    public ViewManager(Joueur joueur, Ennemi ennemi){
        this.joueur = joueur;
        this.ennemi = ennemi;
    }

    public ViewManager(Joueur joueur, ImageView joueurView, Map map, Activity parentActivity, FrameLayout layout_jeu, Context context) {
        this.joueur = joueur;
        this.joueurView = joueurView;
        this.map= map;
        this.parentActivity = parentActivity;
        this.layout_jeu = layout_jeu;
        ennemiViews = new java.util.HashMap<Ennemi, ImageView>();
        attacker = new BasiqueAttacker();
        sound1 = new SoundManager(context, R.raw.pium1);
        sound2 = new SoundManager(context, R.raw.pium2);
        sound3 = new SoundManager(context, R.raw.pium3);
        sound4 = new SoundManager(context, R.raw.pium4);
        sound5 = new SoundManager(context, R.raw.pium5);
        allSound = new ArrayList<>();
        allSound.add(sound1);
        allSound.add(sound2);
        allSound.add(sound3);
        allSound.add(sound4);
        allSound.add(sound5);

        chargementMap(map);

    }

    public void chargementMap(Map map){
        for (Entite ent: map.getAllEntities()) {
            ImageView img = new ImageView(parentActivity);
            //Ajouter id au constructeur de la map donc chaque objet peut avoir un id de type R.string...
            img.setImageResource(ent.getSprite());
            img.setY(ent.getPos().getxPos());
            img.setX(ent.getPos().getyPos());
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ent.getxSize(), ent.getySize());
            layout_jeu.addView(img, lp);
            if(ent.getClass() == Ennemi.class){
                ennemiViews.put((Ennemi) ent, img);
            }
        }
        //creation des attaques, il faut appeler l'attaqueur
        AttackPattern atqJoueur = new AttackPattern(25, 2, 10, 25, "trait", 50);
        atqJoueur.setRGB(0.5,0.5,1);
        joueur.setAttaque(atqJoueur);
        java.util.Map.Entry<Ennemi, ImageView> entry = ennemiViews.entrySet().iterator().next();
        firstEnemi = entry.getKey();
        //ennemiViews.entrySet().iterator().remove();
    }


    public Direction detectEnemi(){
        int xpos = 0;
        int ypos = 0;
        if(firstEnemi != null){
            if(firstEnemi.getX() < joueur.getX()) {
                xpos = -1;
                //manager.updatePositionImages(perso);
                //persoView.setX(persoView.getX()-5); //a changer par des deplaceurs
            }
            else if(firstEnemi.getX() > joueur.getX()) {
                xpos = 1;
                //manager.updatePositionImages(perso);
                //persoView.setX(persoView.getX()+5);                 //a changer par des deplaceurs
            }
            if(firstEnemi.getY() > joueur.getY()) {
                ypos = 1;
                //manager.updatePositionImages(perso);
                //persoView.setY(persoView.getY()+5);                 //a changer par des deplaceurs
            }
            else if(firstEnemi.getY() < joueur.getY()) {
                ypos = -1;
                //manager.updatePositionImages(perso);
                //persoView.setY(persoView.getY()-5);                 //a changer par des deplaceurs
            }
        }
        return new Direction(xpos, ypos);
    }



    @Override
    public void update() {
        joueurView.setX(joueur.getX());
        joueurView.setY(joueur.getY());
        for (java.util.Map.Entry<Ennemi, ImageView> entry : ennemiViews.entrySet()) {
            entry.getValue().setX(entry.getKey().getX());
            entry.getValue().setY(entry.getKey().getY());
            if(entry.getKey().getCurrentHP() <= 0){
                entry.getValue().setVisibility(View.INVISIBLE);
            }
        }
        Attack attaque = attacker.attack(joueur, detectEnemi());
        if (attaque != null) {
            map.addAttack(attaque);
            int index = (int) (Math.random() * allSound.size());
            SoundManager pium = allSound.get(index);
            pium.start();
        }
    }
}
