package fr.iuttest.jeuandroid.model.jeu;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

import fr.iuttest.jeuandroid.data.Niveau;
import fr.iuttest.jeuandroid.data.Niveau1;
import fr.iuttest.jeuandroid.data.Niveau2;
import fr.iuttest.jeuandroid.data.Niveau3;
import fr.iuttest.jeuandroid.data.Niveau4;
import fr.iuttest.jeuandroid.data.Niveau5;
import fr.iuttest.jeuandroid.model.jeu.attack.AtkUpdater;
import fr.iuttest.jeuandroid.model.jeu.attack.Attack;
import fr.iuttest.jeuandroid.model.jeu.attack.BasiqueAttacker;
import fr.iuttest.jeuandroid.model.jeu.collisions.CollisioneurCarre;
import fr.iuttest.jeuandroid.model.jeu.deplacement.DeplacerBasique;
import fr.iuttest.jeuandroid.model.jeu.deplacement.Deplaceur;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.model.jeu.entities.Position;
import fr.iuttest.jeuandroid.model.jeu.maps.Map;
import fr.iuttest.jeuandroid.views.ViewManager;

public class GameManager implements Observer{

    //liste des touches appuyées
//    private HashSet<KeyCode> listeTouches = new HashSet<KeyCode>();
    //dictionnaire des méthodes à effectuer pour certaines touches
//    private Hashtable<KeyCode, String> keyEvents = new Hashtable<KeyCode, String>();
    //dictionnaire précédent avec les clés et valeurs inversées
//    private Hashtable<String, KeyCode> reversedKeyEvents = new Hashtable<String, KeyCode>();
    //carte actuelle
    private Map map;
    //joueur actuel
    private Joueur joueur;
    //ImageView du joueur actu
    private ImageView joueurView;
    //boucle du joueur
    private Loop beep;
    //boucle des ennemis
    private Loop beepEnnemi;

    //J'avais pensé a une boucle pour actualiser la map

    //numéro du niveau
    private Niveau lvl;
    // view manager qui permet de manager la vue
    private ViewManager monViewManager;

    private Context context;

    private DeplacerBasique deplacerBasique;
    private CollisioneurCarre collisioneurCarre;

    public GameManager(Context applicationContext, Joueur joueur, ImageView joueurView, Activity parentActivity, FrameLayout layou_jeu){
        this.joueur = joueur;
        this.joueurView = joueurView;
        this.context = applicationContext;
        init(parentActivity,layou_jeu);
    }

    //charge le premier niveau et les controles
    private void init (Activity parentActivity, FrameLayout layou_jeu){

        lvl = new Niveau1();
        lvl.getLast().setNiveauSuivant(new Niveau2());
        lvl.getLast().setNiveauSuivant(new Niveau3());
        lvl.getLast().setNiveauSuivant(new Niveau4());
        lvl.getLast().setNiveauSuivant(new Niveau5());
        map = lvl.load();

        monViewManager = new ViewManager(joueur, joueurView, map, parentActivity, layou_jeu, context, lvl);

        collisioneurCarre = new CollisioneurCarre(map);
        deplacerBasique = new DeplacerBasique(collisioneurCarre);

        initLoop();
    }

    //instancie la boucle de jeu
    private void initLoop (){
// Pour l'instant faut le laisser comme ça parce qu'on a l'autre truc degueulasse
        beep = new Loop(50);
        beep.start();

        beepEnnemi = new Loop(200);
        beepEnnemi.start();

        IAPathfind ia = new IAPathfind(joueur, map.getEnnemis());

        beep.attacher(monViewManager);
        beepEnnemi.attacher(ia);
    }

    public Map getMap() {
        return map;
    }


    //appel le déplaceur pour déplacer le joueur à droite
    public void deplacerDroite () {
        Direction dir = new Direction(1,0);
        deplacerBasique.deplacer((Personnage)joueur, dir);
    }

    //de meme à gauche
    public void deplacerGauche () {
        Direction dir = new Direction(-1,0);
        deplacerBasique.deplacer((Personnage)joueur, dir);
    }

    //de même en haut
    public void deplacerHaut () {
        Direction dir = new Direction(0,-1); //Pour une raison que je ne comprends si je met 1 ça decends au lieu de monter
        deplacerBasique.deplacer((Personnage)joueur, dir);
    }

    //de même en bas
    public void deplacerBas () {
        Direction dir = new Direction(0,1); //Pour une raison que je ne comprends si je met -1 ça monte au lieu de decendre
        deplacerBasique.deplacer((Personnage)joueur, dir);
    }

    //appel l'attacker pour instancier une attaque
    public void attaqueHaut () {
        BasiqueAttacker attacker = new BasiqueAttacker();
        Attack attaque = attacker.attack(joueur, new Direction(0,-1 ));
        if (attaque != null) {
            map.addAttack(attaque);
        }
    }


//    //appel le pathfincding et un déplaceur pour déplacer l'ennemi
//    public void updateEnemi(){
//        IA enemiIA = new IAPathfind();
//        Deplaceur deplace = new DeplacerBasique(new CollisioneurCarre(map));
//        for (Personnage ennemi : map.getEnnemis()){
//            ennemi.getAttaque().setCurrentcooldown(ennemi.getAttaque().getCurrentcooldown()-1);
//            Direction dir = enemiIA.approcheJoueur(joueur, ennemi, map);
//            deplace.deplacer(ennemi, new Direction(dir.getxDir(),0));
//            deplace.deplacer(ennemi, new Direction(0,dir.getyDir()));
//        }
//    }

    //appel un déplaceur d'attaque pour déplacer les attaques
    public void updateAttaque(){
        joueur.getAttaque().setCurrentcooldown(joueur.getAttaque().getCurrentcooldown()-1);
        AtkUpdater updater = new AtkUpdater();
        updater.updateAttack(map);
    }

    public Joueur getJoueur() {
        return joueur;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public ImageView getJoueurView() { return joueurView; }
    public void setJoueurView(ImageView joueurView) { this.joueurView = joueurView; }

    public Loop getBeep() {
        return beep;
    }

    public Loop getBeepEnnemi() {
        return beepEnnemi;
    }

    //passe le niveau courant au niveau suivant
    public Boolean niveauSuivant (){
        if (lvl.getNiveauSuivant() != null) {
            map.removeAll();
            lvl = lvl.getNiveauSuivant();
            map = lvl.load();
            map.setHeight(500);
            map.setWidth(500);
            joueur = map.getJoueur();
            return true;
        }
        return false;
    }

    //arrête les boucles
    public void stopBoucle(){
        beep.interrupt();
        beepEnnemi.interrupt();
    }


    public ImageView updatePositionImages(ImageView pers){
        Position pos = joueur.getPos();
        pers.setX(pos.getxPos());
        pers.setY(pos.getyPos());
        return pers;
    }

    public void interrupt() {
        beep.interrupt();
        beepEnnemi.interrupt();
    }

    @Override
    public void update() {
        updateAttaque();
    }

    public void resume() {
        beep.repprendre();
        beepEnnemi.repprendre();
    }
}
