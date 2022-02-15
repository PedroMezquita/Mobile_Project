package fr.iuttest.jeuandroid.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.test.Personnages;
import fr.iuttest.jeuandroid.model.test.Stub;
import fr.iuttest.jeuandroid.views.fragment.FragmentMaster;

public class FenetrePrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_principal);
    }

    public void clickJouer(View view) {
        Intent intent = new Intent(this, MasterDetailPerso.class);
        startActivity(intent);
    }

    public void clickParametre(View view) {
        Intent intent = new Intent(this,FenetreParametre.class);
        startActivity(intent);
    }

    public void clickQuitter(View view) {
        finish();
    }
}
