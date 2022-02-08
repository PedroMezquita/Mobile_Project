package fr.iuttest.jeuandroid.model.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.iuttest.jeuandroid.R;

public class MonAdaptateur extends RecyclerView.Adapter{

    private List<Object> list;

    public MonAdaptateur(List<Object> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_recycler_view, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //down cast holder en ViewHolder
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
