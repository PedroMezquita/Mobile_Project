package fr.iuttest.jeuandroid.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.test.Personnages;
import fr.iuttest.jeuandroid.model.test.Stub;
import fr.iuttest.jeuandroid.views.fragment.FragmentMaster;

public class MasterDetailPerso extends AppCompatActivity {

    private Personnages listPerso;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_personnages);

        listPerso = Stub.create();

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.master_detail_perso, FragmentMaster.class, null)
                .commit();
    }

    public Personnages getListPerso() { return listPerso; }
}
