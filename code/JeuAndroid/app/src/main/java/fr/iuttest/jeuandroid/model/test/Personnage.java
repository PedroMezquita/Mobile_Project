package fr.iuttest.jeuandroid.model.test;

public class Personnage {

    private String nom;

    public Personnage(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
