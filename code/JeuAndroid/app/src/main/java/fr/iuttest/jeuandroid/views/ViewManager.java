package fr.iuttest.jeuandroid.views;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.Loop;
import fr.iuttest.jeuandroid.model.jeu.PlayerObserver;
import fr.iuttest.jeuandroid.model.jeu.entities.Ennemi;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;

public class ViewManager implements PlayerObserver {

    private Joueur joueur;
    private ImageView joueurView;

    private Ennemi ennemi;
    private ImageView ennemiView;

    private FenetreJeu fenetreJeu;


    public ViewManager(Joueur joueur, Ennemi ennemi, Activity activity){
        this.joueur = joueur;
        this.ennemi = ennemi;

        Intent intent = new Intent(activity, FenetreJeu.class);
        intent.putExtra("Joueur",joueur); // envoyer le joueur par extra
        activity.startActivity(intent);
    }

    @Override
    public void updatePlayer() {
        joueurView.setX(joueur.getPos().getxPos());
        System.out.println(joueurView.getX());
        joueurView.setY(joueur.getPos().getyPos());
    }
}
