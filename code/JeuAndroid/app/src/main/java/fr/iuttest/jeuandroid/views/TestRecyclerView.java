package fr.iuttest.jeuandroid.views;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.test.Personnages;
import fr.iuttest.jeuandroid.model.test.Stub;


public class TestRecyclerView extends AppCompatActivity {

    private Personnages listePersos;

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
