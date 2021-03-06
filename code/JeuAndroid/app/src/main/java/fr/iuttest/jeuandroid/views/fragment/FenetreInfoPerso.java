package fr.iuttest.jeuandroid.views.fragment;

import static java.lang.String.valueOf;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.iuttest.jeuandroid.R;

public class FenetreInfoPerso extends Fragment {

    private MasterDetailPerso activiteParente;

    public FenetreInfoPerso() {
        super(R.layout.fragment_details);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activiteParente = (MasterDetailPerso) getContext();
        updateData();
    }


    public void updateData() {
        if(getActivity() != null){
            if(activiteParente.getPersoEnCours() != null){
                ((TextView) getActivity().findViewById(R.id.stat_perso1)).setText(valueOf(activiteParente.getPersoEnCours().getName()));
                ((TextView) getActivity().findViewById(R.id.stat_perso2)).setText(getString(R.string.Attaque)+valueOf(activiteParente.getPersoEnCours().getAtkPnt()));
                ((TextView) getActivity().findViewById(R.id.stat_perso3)).setText(getString(R.string.HP)+valueOf(activiteParente.getPersoEnCours().getMaxHP()));
                ((TextView) getActivity().findViewById(R.id.stat_perso4)).setText(getString(R.string.Vitesse)+valueOf(activiteParente.getPersoEnCours().getSpeed()));
            }
            else{
                ((TextView) getActivity().findViewById(R.id.stat_perso1)).setText("----");
                ((TextView) getActivity().findViewById(R.id.stat_perso2)).setText("----");
                ((TextView) getActivity().findViewById(R.id.stat_perso3)).setText("----");
                ((TextView) getActivity().findViewById(R.id.stat_perso4)).setText("----");
            }
        }
    }
}
