package fr.iuttest.jeuandroid.model.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.iuttest.jeuandroid.R;
import fr.iuttest.jeuandroid.model.jeu.entities.Joueur;

public class MonAdaptateur extends RecyclerView.Adapter{

    private List<Joueur> list;
    private AppCompatActivity activiteParent;

    public MonAdaptateur(List<Joueur> list, AppCompatActivity activiteParent) {
        this.list = list;
        this.activiteParent = activiteParent;
    }

    @NonNull
    @Override
    public ViewHolderPers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout layout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_recycler_view, parent , false);
        return new ViewHolderPers(layout);
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Joueur perso = list.get(position);
        ((ViewHolderPers)holder).setPersoEnCours(perso);
        ((ViewHolderPers)holder).getButton().setText(perso.getName());
        ((ViewHolderPers)holder).getImageView().setImageDrawable(activiteParent.getDrawable(R.drawable.template_character));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
