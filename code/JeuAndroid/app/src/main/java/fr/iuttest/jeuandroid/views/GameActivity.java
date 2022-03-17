package fr.iuttest.jeuandroid.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.Loop;
import fr.iuttest.jeuandroid.model.jeu.GameManager;
import fr.iuttest.jeuandroid.model.jeu.deplacement.DeplacerBasique;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;

public class GameActivity extends AppCompatActivity {

    private GameManager gameManager;
    private FrameLayout layout_jeu;
    private ImageView persoView;
    private ImageView enemiView;
    private Joueur perso;
    private Loop beep;
    private Loop beepEnnemi;
    private Activity activiteParente;
    private float initialPositionx;
    private float initialPositiony;
    private DeplacerBasique deplaceur;
    private int firstTouch = 0;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_jeu);

        this.activiteParente = getParent();
        layout_jeu = (FrameLayout) findViewById(R.id.jeu);
        initialiserJoueur();
        gameManager = new GameManager(getApplicationContext(), perso, persoView, this, layout_jeu);
    }

    private void initialiserJoueur(){
        perso = (Joueur) getIntent().getSerializableExtra("persoEnCours");
        persoView = new ImageView(this);
        persoView = (ImageView) findViewById(R.id.imageView);
        persoView.setImageResource(perso.getSprite());
        persoView.setMaxWidth(82);
        persoView.setMaxHeight(95);
        persoView.setX(500);
        persoView.setY(100);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onStart() {
        super.onStart();
//        initLoop();

        //SUPER IDEE DU PROF: Faire un observeur pour notifier l'Image View lors qu'on change l'objet

        layout_jeu.setOnTouchListener((view, motionEvent) -> {
            /*
            // Faire suivre le personage au doigt de l'utilisateur, j'aurais prefere qu'on puisse juste le faire bouger sans mettre le doigt sur lui mais bon, au moins ça marche
            perso.setX(motionEvent.getX() - perso.getWidth()/2);
            perso.setY(motionEvent.getY() - perso.getHeight()/2);
            //
            */

            final int action = motionEvent.getAction();

            switch(action){
                case MotionEvent.ACTION_DOWN:
                    initialPositionx = motionEvent.getX();
                    initialPositiony = motionEvent.getY();

                case MotionEvent.ACTION_MOVE:
                    if(motionEvent.getX() < initialPositionx-100) {
                        gameManager.deplacerGauche();
//                        manager.updatePositionImages(perso);
//                        persoView.setX(persoView.getX()-5); //a changer par des deplaceurs
                    }else if(motionEvent.getX() > initialPositionx+100) {

                        gameManager.deplacerDroite();
//                        manager.updatePositionImages(perso);
//                        persoView.setX(persoView.getX()+5);                 //a changer par des deplaceurs
                    }
                    if(motionEvent.getY() > initialPositiony+100) {

                        gameManager.deplacerBas();
//                        manager.updatePositionImages(perso);
 //                       persoView.setY(persoView.getY()+5);                 //a changer par des deplaceurs
                    }else if(motionEvent.getY() < initialPositiony-100) {

                        gameManager.deplacerHaut();
//                        manager.updatePositionImages(perso);
   //                     persoView.setY(persoView.getY()-5);                 //a changer par des deplaceurs
                    }
            }

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

/*
    public void initLoop(){
          beep = new Loop(50, enemiView, persoView);
          beepEnnemi = new Loop(200, enemiView, persoView);

//        beep.attacher(new MainObserver(this));
//
//        beepEnnemi.attacher(new EnnemiObserver(this));
          beep.start();
          beepEnnemi.start();
//
        }
*/
        /*
    public void updateAttaque(){
        joueur.getAttaque().setCurrentcooldown(joueur.getAttaque().getCurrentcooldown()-1);
        AtkUpdater updater = new AtkUpdater();
        updater.updateAttack(map);
    }
*/
}