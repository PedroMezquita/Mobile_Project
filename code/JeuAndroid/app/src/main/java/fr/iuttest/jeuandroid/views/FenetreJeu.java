package fr.iuttest.jeuandroid.views;

import android.annotation.SuppressLint;
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

public class FenetreJeu extends AppCompatActivity {

    private ConstraintLayout layout_jeu;
    private ImageView perso;
    private ImageView enemi;
    private Loop beep;
    private Loop beepEnnemi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_jeu);
    }


    @Override
    protected void onStart() {
        super.onStart();
        perso = (ImageView) findViewById(R.id.imageView);
        enemi = (ImageView) findViewById(R.id.imageViewEnemmi);
        layout_jeu = (ConstraintLayout) findViewById(R.id.jeu);

        layout_jeu.setOnTouchListener((view, motionEvent) -> {

            // Faire suivre le personage au doigt de l'utilisateur, j'aurais prefere qu'on puisse juste le faire bouger sans mettre le doigt sur lui mais bon, au moins ça marche
            perso.setX(motionEvent.getX() - perso.getWidth()/2);
            perso.setY(motionEvent.getY() - perso.getHeight()/2);
            //
            return true;

        });


    }

    public void initLoop(){
          beep = new Loop(50);
          beepEnnemi = new Loop(200);

//        beep.attacher(new MainObserver(this));
//
//        beepEnnemi.attacher(new EnnemiObserver(this));
          beep.start();
          beepEnnemi.start();
//
        }

}
