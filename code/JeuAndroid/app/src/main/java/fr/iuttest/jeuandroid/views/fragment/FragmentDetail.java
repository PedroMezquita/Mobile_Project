package fr.iuttest.jeuandroid.views.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.views.MasterDetailPerso;


public class FragmentDetail extends Fragment {
    private MasterDetailPerso activiteParente;

    public FragmentDetail(){ super(R.layout.fragment_details); }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activiteParente = (MasterDetailPerso) getContext();
    }
}
