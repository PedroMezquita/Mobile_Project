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


    private void updateData() {
        if(getActivity() != null){
            if(activiteParente.getPersoEnCours() != null){
                ((TextView) getActivity().findViewById(R.id.stat_perso)).setText(valueOf(activiteParente.getPersoEnCours().getAtkPnt()));
                ((TextView) getActivity().findViewById(R.id.stat_perso)).setText(valueOf(activiteParente.getPersoEnCours().getAtkPnt()));
                ((TextView) getActivity().findViewById(R.id.stat_perso)).setText(valueOf(activiteParente.getPersoEnCours().getAtkPnt()));
                ((TextView) getActivity().findViewById(R.id.stat_perso)).setText(valueOf(activiteParente.getPersoEnCours().getAtkPnt()));
            }
            else {
                try {
                    ((TextView) getActivity().findViewById(R.id.stat_perso)).setText("----");
                    Toast totot = new Toast(activiteParente);
                    totot.setText("------------");
                    totot.show();
                } catch (NullPointerException e) {
                    //Absorbtion de l'exception qui survient lorsque l'on passe de paysage à portrait et qui est du à la disparition du fragment.
                }
            }
        }
    }
}
