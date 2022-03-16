package fr.iuttest.jeuandroid.model.jeu;

public class MainObserver implements Observer{

    GameManager gameManager;

    public MainObserver (GameManager gameManager){
        this.gameManager = gameManager;
    }

    //demande au manager de lire les touches appuyées
    @Override
    public void update () {
//        Platform.runLater(()->{
//            System.out.println(manager.getListeTouches());
//            manager.readKeys();
            gameManager.updateAttaque();
//        });
    }
}
