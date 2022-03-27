package fr.iuttest.jeuandroid.model.jeu.maps;
//
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import model.attack.Attack;
//import model.entities.Ennemi;
//import model.entities.Entite;
//import model.entities.Joueur;
//
import java.util.ArrayList;

import fr.iuttest.jeuandroid.model.jeu.attack.Attack;
import fr.iuttest.jeuandroid.model.jeu.entities.Ennemi;
import fr.iuttest.jeuandroid.model.jeu.entities.Entite;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.entities.Props;

//
public class Map {
    //liste de toutes le entités
    private ArrayList<Entite> allEntities = new ArrayList<Entite>();
    //entités récement supprimées de allEntities
    private ArrayList<Entite> removedEntities = new ArrayList<Entite>();
    //entités récement ajoutées à allEntities
    private ArrayList<Entite> newEntities = new ArrayList<Entite>();
    //liste des attaques sur la carte
    private ArrayList<Attack> allAttacks = new ArrayList<Attack>();
    //Liste blocs
    private ArrayList<Props> allBlocs = new ArrayList<>();
    //liste des ennemis sur la carte
    private ArrayList<Ennemi> allEnemi = new ArrayList<Ennemi>();
    //liste des sprite des ennemis
    private ArrayList<Integer> allSpriteEnnemi = new ArrayList<Integer>();
    //nombre d'entite sur la carte
    private int nbEntite; //integer property a la base
    //nombre d'enemis
    private int nbEnemis; //integer property a la base

    public void addEntity(Entite entity) {
        allEntities.add(entity);
        newEntities.add(entity);
        setNbEntite(getNbEntite()+1);
    }

    public void addAttack (Attack atk){
        allAttacks.add(atk);
        addEntity(atk);
    }

    public ArrayList<Entite> getAllEntities() {
        return allEntities;
    }

    @Override
    public String toString() {
        return allEntities.toString();
    }

    public Joueur getJoueur() {
        for (Entite entity : getAllEntities()) {
            if (entity.getId() == "joueur") {
                return (Joueur) entity;
            }
        }
        return null;
    }

    public ArrayList<Ennemi> getEnnemis(){
        return (ArrayList<Ennemi>) allEnemi.clone();
    }

    public int getNbEntite() {
        return nbEntite;
    }

    public void setNbEntite(int nbEntite) {
        this.nbEntite = nbEntite;
    }

    public void removeEntity (Entite entity){
        allEntities.remove(entity);
        removedEntities.add(entity);
        setNbEntite(getNbEntite()-1);
    }

    public void removeAttack (Attack atk){
        allAttacks.remove(atk);
        removeEntity(atk);
    }

    public void addEnemy (Ennemi enmy){
        allEnemi.add(enmy);
        setNbEnnemis(getNbEnnemis()+1);
        addEntity(enmy);
    }

    public void addProps(Props props){
        allBlocs.add(props);
        addEntity(props);
    }

    public void removeEnemy (Ennemi enemy){
        allEnemi.remove(enemy);
        setNbEnnemis(getNbEnnemis()-1);
        removeEntity(enemy);
    }

    public ArrayList<Attack> getAllAttacks() {
        return (ArrayList<Attack>) allAttacks.clone();
    }

    public int getNbEnnemis() { return nbEnemis; }

    public void setNbEnnemis(int nbEntite) {
        this.nbEnemis = nbEntite;
    }

    public ArrayList<Entite> getRemovedEntities() {
        return (ArrayList<Entite>) removedEntities.clone();
    }

    public void eraseEntity (Entite entite){
        removedEntities.remove(entite);
    }

    public void handleEntity (Entite entite){
        newEntities.remove(entite);
    }

    public ArrayList<Entite> getNewEntities() {
        return (ArrayList<Entite>) newEntities.clone();
    }

    public void removeAll(){
        allEnemi.removeAll(allEnemi);
        allAttacks.removeAll(allAttacks);
        allEntities.removeAll(allEntities);
        setNbEntite(0);
    }

    public ArrayList<Integer> getAllSpriteEnnemi() {
        return allSpriteEnnemi;
    }
    public ArrayList<Props> getAllBlocs(){ return (ArrayList<Props>) allBlocs.clone();}
    public void setAllSpriteEnnemi(ArrayList<Integer> allSpriteEnnemi) {
        this.allSpriteEnnemi = allSpriteEnnemi;
    }
}
