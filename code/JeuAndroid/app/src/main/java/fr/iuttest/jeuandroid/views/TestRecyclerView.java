package fr.iuttest.jeuandroid.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fr.iuttest.jeuandroid.R;
//import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.model.test.Personnage;
import fr.iuttest.jeuandroid.model.test.Personnages;
import fr.iuttest.jeuandroid.model.test.Stub;


public class TestRecyclerView extends AppCompatActivity {

    private Personnages listePersos; //est que ceci serais pas mieux en arrayList ?


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recycler_view);

        listePersos = Stub.create();
    }


    public void clickQuitter(View view) {
        finish();
    }

}
