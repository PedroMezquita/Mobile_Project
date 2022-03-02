package fr.iuttest.jeuandroid.model.jeu;


public class EnnemiObserver implements Observer{

    Manager manager;

    public EnnemiObserver (Manager manager){
        this.manager = manager;
    }

    //met a jour les ennemis à chaque tour de boucle
    @Override
    public void update() {
//        Platform.runLater(()->{
            manager.updateEnemi();
//        });
    }
}
