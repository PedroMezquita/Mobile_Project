package fr.iuttest.jeuandroid.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.Loop;
import fr.iuttest.jeuandroid.model.jeu.Manager;
import fr.iuttest.jeuandroid.model.jeu.entities.Ennemi;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;

public class FenetreJeu extends AppCompatActivity {

    private ConstraintLayout layout_jeu;
    private Joueur joueur;
    private ImageView joueurView;
    private Ennemi ennemi;
    private ImageView ennemiView;
    private Loop beep;
    private Loop beepEnnemi;
    private Activity activiteParente;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activiteParente = getParent();
        setContentView(R.layout.fenetre_jeu);
        joueurView = findViewById(R.id.imageView);
        ennemiView = findViewById(R.id.imageViewEnemmi);

        //récupérer joueur par extra
    }


    @Override
    protected void onStart() {
        super.onStart();
        layout_jeu = (ConstraintLayout) findViewById(R.id.jeu);
        layout_jeu.setOnTouchListener((view, motionEvent) -> {
            // Faire suivre le personage au doigt de l'utilisateur, j'aurais prefere qu'on puisse juste le faire bouger sans mettre le doigt sur lui mais bon, au moins ça marche
            joueur.setX((int) (motionEvent.getX() - joueurView.getWidth()/2));
            joueur.setY((int) (motionEvent.getY() - joueurView.getHeight()/2));
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


    public void lancerBoucle(){initLoop();}

    public void initLoop(){
          beep = new Loop(50, ennemiView, joueurView);
          beepEnnemi = new Loop(200, ennemiView, joueurView);

//        beep.attacher(new MainObserver(this));
//
//        beepEnnemi.attacher(new EnnemiObserver(this));
          beep.start();
          beepEnnemi.start();
//
        }

    public void setPlayer(Joueur joueur) {this.joueur = joueur;}
    public void setEnnemi(Ennemi ennemi) {this.ennemi = ennemi;}
    public void setPlayerView(ImageView joueurView) {this.joueurView = joueurView;}
    public void setEnnemiView(ImageView ennemiView) {this.ennemiView = ennemiView;}
/*
    public void updateAttaque(){
        joueur.getAttaque().setCurrentcooldown(joueur.getAttaque().getCurrentcooldown()-1);
        AtkUpdater updater = new AtkUpdater();
        updater.updateAttack(map);
    }
*/
}
