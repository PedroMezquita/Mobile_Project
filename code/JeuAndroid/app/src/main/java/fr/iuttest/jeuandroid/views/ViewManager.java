package fr.iuttest.jeuandroid.views;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Set;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.Loop;
import fr.iuttest.jeuandroid.model.jeu.Observer;
import fr.iuttest.jeuandroid.model.jeu.PlayerObserver;
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

    private Activity parentActivity;

    private FrameLayout layout_jeu;

    private Map map;


    public ViewManager(Joueur joueur, Ennemi ennemi){
        this.joueur = joueur;
        this.ennemi = ennemi;
    }

    public ViewManager(Joueur joueur, ImageView joueurView, Map map, Activity parentActivity, FrameLayout layout_jeu) {
        this.joueur = joueur;
        this.joueurView = joueurView;
        this.map= map;
        this.parentActivity = parentActivity;
        this.layout_jeu = layout_jeu;
        ennemiViews = new java.util.Map<Ennemi, ImageView>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsValue(@Nullable Object o) {
                return false;
            }

            @Nullable
            @Override
            public ImageView get(@Nullable Object o) {
                return null;
            }

            @Nullable
            @Override
            public ImageView put(Ennemi ennemi, ImageView imageView) {
                return null;
            }

            @Nullable
            @Override
            public ImageView remove(@Nullable Object o) {
                return null;
            }

            @Override
            public void putAll(@NonNull java.util.Map<? extends Ennemi, ? extends ImageView> map) {

            }

            @Override
            public void clear() {

            }

            @NonNull
            @Override
            public Set<Ennemi> keySet() {
                return null;
            }

            @NonNull
            @Override
            public Collection<ImageView> values() {
                return null;
            }

            @NonNull
            @Override
            public Set<Entry<Ennemi, ImageView>> entrySet() {
                return null;
            }

            @Override
            public boolean equals(@Nullable Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
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
    }

    @Override
    public void update() {
        joueurView.setX(joueur.getX());
        joueurView.setY(joueur.getY());
        for (java.util.Map.Entry<Ennemi, ImageView> entry : ennemiViews.entrySet()) {
            entry.getValue().setX(entry.getKey().getX());
            entry.getValue().setY(entry.getKey().getY());
        }
    }
}
