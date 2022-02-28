package fr.iuttest.jeuandroid.model.test;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.views.fragment.MasterDetailPerso;

public class ViewHolderPers extends RecyclerView.ViewHolder {

    private Button button;
    private TextView textViewStats;

    public ViewHolderPers(@NonNull View itemView) {
        super(itemView);
        button = (Button) itemView.findViewById(R.id.buttonViewPerso);
        textViewStats = (TextView) itemView.findViewById(R.id.textViewStats);
    }

    public TextView getButton() { return button; }
    public TextView getTextViewStats() {return  textViewStats; }

    public void setPersoEnCours(Joueur persoEnCours){
        button.setOnClickListener(v -> {
            ((MasterDetailPerso) button.getContext()).setPersoEnCours(persoEnCours);});
    }
}
