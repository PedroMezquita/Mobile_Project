package fr.iuttest.jeuandroid.model.test;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;

public class MonAdaptateur extends RecyclerView.Adapter{

    private List<Joueur> list;

    public MonAdaptateur(List<Joueur> list) { this.list = list; }

    @NonNull
    @Override
    public ViewHolderPers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_recycler_view, parent , false);
        return new ViewHolderPers(layout);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Joueur perso = list.get(position);
        ((ViewHolderPers)holder).setPersoEnCours(perso);
        ((ViewHolderPers)holder).getButton().setText(perso.getName());
        ((ViewHolderPers)holder).getTextViewStats().setText(perso.toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
