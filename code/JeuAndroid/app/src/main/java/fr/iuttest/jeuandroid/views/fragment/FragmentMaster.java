package fr.iuttest.jeuandroid.views.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.test.MonAdaptateur;

public class FragmentMaster extends Fragment {

    private MasterDetailPerso activiteParent;

    public FragmentMaster() {
        super(R.layout.fragment_master);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activiteParent = (MasterDetailPerso) getContext();
        RecyclerView listView = view.findViewById(R.id.list_perso);
        listView.setLayoutManager(new LinearLayoutManager(activiteParent));
        listView.setAdapter(new MonAdaptateur(activiteParent.getListPerso().getListPerso()));
    }
}
