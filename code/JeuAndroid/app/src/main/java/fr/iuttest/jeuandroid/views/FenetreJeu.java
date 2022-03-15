package fr.iuttest.jeuandroid.views;

import android.app.Activity;
import android.app.admin.SystemUpdateInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.Loop;
import fr.iuttest.jeuandroid.model.jeu.Manager;
import fr.iuttest.jeuandroid.model.jeu.deplacement.DeplacerBasique;
import fr.iuttest.jeuandroid.model.jeu.entities.Entite;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;

public class FenetreJeu extends AppCompatActivity {

    private Manager manager;
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
        manager = new Manager();
        layout_jeu = (FrameLayout) findViewById(R.id.jeu);
        initialiserJoueur();
        manager.setJoueur(perso);
    }


    @Override
    protected void onStart() {
        super.onStart();
        chargementMap(manager.getMap());
        enemiView = (ImageView) findViewById(R.id.imageViewEnemmi);
        initLoop();

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
//                        manager.deplacerGauche();
//                        manager.updatePositionImages(perso);
                        persoView.setX(persoView.getX()-5); //a changer par des deplaceurs
                    }else if(motionEvent.getX() > initialPositionx+100) {

//                        manager.deplacerDroite();
//                        manager.updatePositionImages(perso);
                        persoView.setX(persoView.getX()+5);                 //a changer par des deplaceurs
                    }
                    if(motionEvent.getY() > initialPositiony+100) {

//                        manager.deplacerHaut();
//                        manager.updatePositionImages(perso);
                        persoView.setY(persoView.getY()+5);                 //a changer par des deplaceurs
                    }else if(motionEvent.getY() < initialPositiony-100) {

//                        manager.deplacerBas();
//                        manager.updatePositionImages(perso);
                        persoView.setY(persoView.getY()-5);                 //a changer par des deplaceurs
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

    public void chargementMap(Map map){
        for (Entite ent: map.getAllEntities()) {
            ImageView img = new ImageView(this);
            //Ajouter id au constructeur de la map donc chaque objet peut avoir un id de type R.string...
            img.setImageResource(ent.getSprite());
            img.setY(ent.getPos().getxPos());
            img.setX(ent.getPos().getyPos());
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ent.getxSize(), ent.getySize());
            layout_jeu.addView(img, lp);
        }

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

        /*
    public void updateAttaque(){
        joueur.getAttaque().setCurrentcooldown(joueur.getAttaque().getCurrentcooldown()-1);
        AtkUpdater updater = new AtkUpdater();
        updater.updateAttack(map);
    }
*/
}
