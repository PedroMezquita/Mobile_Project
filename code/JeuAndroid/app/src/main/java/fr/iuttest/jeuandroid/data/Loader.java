package fr.iuttest.jeuandroid.data;


import fr.iuttest.jeuandroid.model.jeu.maps.Map;

//interface de chargement des données
public interface Loader {
    //méthode permettant de charger une Map
    Map load ();
}
