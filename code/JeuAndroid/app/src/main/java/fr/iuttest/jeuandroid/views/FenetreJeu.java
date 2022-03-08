package fr.iuttest.jeuandroid.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.Loop;
import fr.iuttest.jeuandroid.model.jeu.attack.AtkUpdater;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.views.fragment.MasterDetailPerso;

public class FenetreJeu extends AppCompatActivity {

    private ConstraintLayout layout_jeu;
    private ImageView perso;
    private ImageView enemi;
    private Loop beep;
    private Loop beepEnnemi;
    private Activity activiteParente;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activiteParente = getParent();
        setContentView(R.layout.fenetre_jeu);
    }


    @Override
    protected void onStart() {
        super.onStart();
        perso = (ImageView) findViewById(R.id.imageView);
        enemi = (ImageView) findViewById(R.id.imageViewEnemmi);
        layout_jeu = (ConstraintLayout) findViewById(R.id.jeu);
        initLoop();

        //SUPER IDEE DU PROF: Faire un observeur pour notifier l'Image View lors qu'on change l'objet

        layout_jeu.setOnTouchListener((view, motionEvent) -> {

            // Faire suivre le personage au doigt de l'utilisateur, j'aurais prefere qu'on puisse juste le faire bouger sans mettre le doigt sur lui mais bon, au moins ça marche
            perso.setX(motionEvent.getX() - perso.getWidth()/2);
            perso.setY(motionEvent.getY() - perso.getHeight()/2);
            //

            return true;

        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        beep.interrupt();
        beepEnnemi.interrupt();
    }

    @Override
    protected void onStop() {
        super.onStop();
        beep.interrupt();
        beepEnnemi.interrupt();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        beep.interrupt();
        beepEnnemi.interrupt();
    }


    public void initLoop(){
          beep = new Loop(50, enemi, perso);
          beepEnnemi = new Loop(200, enemi, perso);

//        beep.attacher(new MainObserver(this));
//
//        beepEnnemi.attacher(new EnnemiObserver(this));
          beep.start();
          beepEnnemi.start();
//
        }
/*
    public void updateAttaque(){
        joueur.getAttaque().setCurrentcooldown(joueur.getAttaque().getCurrentcooldown()-1);
        AtkUpdater updater = new AtkUpdater();
        updater.updateAttack(map);
    }
*/
}
