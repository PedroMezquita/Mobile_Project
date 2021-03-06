package fr.iuttest.jeuandroid.views.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.test.Personnages;
import fr.iuttest.jeuandroid.model.test.Stub;
import fr.iuttest.jeuandroid.views.GameActivity;

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

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.container_de_detail, FenetreInfoPerso.class, null)
                    .commit();
        }
    }

    public void setPersoEnCours(Joueur persoEnCours) {
        if(this.persoEnCours != persoEnCours) {
            if (persoEnCours != null) {
                this.persoEnCours = persoEnCours;
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    ((FenetreInfoPerso) getSupportFragmentManager().findFragmentById(R.id.container_de_detail)).updateData();
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_fragment, FenetreInfoPerso.class, null)
                            .setReorderingAllowed(true)
                            .commit();
                }
            }
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
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("persoEnCours", persoEnCours);
        startActivity(intent);
    }


    public void clickRetourMenu(View view){finish();}

    public Personnages getListPerso() { return listPerso; }
    public Joueur getPersoEnCours() {return persoEnCours;}
}
