package fr.iuttest.jeuandroid.model.jeu;


public class EnnemiObserver implements Observer{

    GameManager gameManager;

    public EnnemiObserver (GameManager gameManager){
        this.gameManager = gameManager;
    }

    //met a jour les ennemis à chaque tour de boucle
    @Override
    public void update() {
//        Platform.runLater(()->{
//            manager.updateEnemi();
//        });
    }
}
