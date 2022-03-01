package fr.iuttest.jeuandroid.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.model.test.Personnages;
import fr.iuttest.jeuandroid.model.test.Stub;
import fr.iuttest.jeuandroid.views.FenetrePrincipal;
import fr.iuttest.jeuandroid.views.fragment.FenetreInfoPerso;
import fr.iuttest.jeuandroid.views.fragment.FragmentMaster;

public class MasterDetailPerso extends AppCompatActivity {

    private Personnages listPerso;
    private Joueur persoEnCours;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_personnages);

        listPerso = Stub.create();

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.container_fragment, FragmentMaster.class, null)
                .commit();
    }

    public void setPersoEnCours(Joueur persoEnCours) {
        if(this.persoEnCours != persoEnCours && persoEnCours!= null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment, FenetreInfoPerso.class, null)
                    .setReorderingAllowed(true)
                    .commit();
        }
        this.persoEnCours = persoEnCours;
    }

    public void clickRetour(View view){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container_fragment, FragmentMaster.class, null)
                .commit();
        persoEnCours = null;
    }

    public void clickJeu(View view) {
        Intent intent = new Intent(this, FenetrePrincipal.class);
        startActivity(intent);
    }

    public void clickRetourMenu(View view){finish();}

    public Personnages getListPerso() { return listPerso; }
    public Joueur getPersoEnCours() {return persoEnCours;}
}
