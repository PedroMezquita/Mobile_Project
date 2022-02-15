package fr.iuttest.jeuandroid.model.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.iuttest.jeuandroid.R;

public class MonAdaptateur extends RecyclerView.Adapter{

    private List<Personnage> list;

    public MonAdaptateur(List<Personnage> list) { this.list = list; }

    @NonNull
    @Override
    public ViewHolderPers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.cellule_recycler_view, parent , false);
        return new ViewHolderPers(layout);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Personnage perso = list.get(position);
        ((ViewHolderPers)holder).getTextView().setText(perso.getNom());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
