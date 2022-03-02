package fr.iuttest.jeuandroid.model.jeu;

public class MainObserver implements Observer{

    Manager manager;

    public MainObserver (Manager manager){
        this.manager = manager;
    }

    //demande au manager de lire les touches appuyées
    @Override
    public void update () {
//        Platform.runLater(()->{
//            System.out.println(manager.getListeTouches());
//            manager.readKeys();
            manager.updateAttaque();
//        });
    }
}
