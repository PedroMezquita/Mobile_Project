package fr.iuttest.jeuandroid.model.test;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;
import fr.iuttest.jeuandroid.model.jeu.entities.Personnage;
import fr.iuttest.jeuandroid.views.fragment.MasterDetailPerso;

public class ViewHolderPers extends RecyclerView.ViewHolder {

    private Button button;
    private ImageView imageView;

    public ViewHolderPers(@NonNull View itemView) {
        super(itemView);
        button = (Button) itemView.findViewById(R.id.buttonViewPerso);
        imageView = (ImageView)  itemView.findViewById(R.id.imageView);
    }

    public Button getButton() { return button; }
    public ImageView getImageView() {return  imageView; }

    public void setPersoEnCours(Joueur persoEnCours){
        button.setOnClickListener(v -> {
            ((MasterDetailPerso) button.getContext()).setPersoEnCours(persoEnCours);});
    }
}
