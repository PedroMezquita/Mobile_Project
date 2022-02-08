package fr.iuttest.jeuandroid.model.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.iuttest.jeuandroid.R;

public class MonAdaptateur extends RecyclerView.Adapter<ViewHolder>{

    private List<Object> list; //Je pense qu'il faudra faire de 'String', ou ça prend automatiquement le toString ?
    private List<String> listString;

    public MonAdaptateur(List<Object> list) {
        this.list = list;
        for (Object obj : list){
            listString.add(obj.toString());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_recycler_view, parent , false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(listString.get(position));
        //down cast holder en ViewHolder
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
