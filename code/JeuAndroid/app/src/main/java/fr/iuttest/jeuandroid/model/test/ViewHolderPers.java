package fr.iuttest.jeuandroid.model.test;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.iuttest.jeuandroid.R;

public class ViewHolderPers extends RecyclerView.ViewHolder {

    private TextView textView;
    private TextView textViewStats;

    public ViewHolderPers(@NonNull View itemView) {
        super(itemView);
        textView = (Button) itemView.findViewById(R.id.buttonViewEtud);
        textViewStats = (TextView) itemView.findViewById(R.id.textViewStats);
    }

    public TextView getTextView() { return textView; }

    public TextView getTextViewStats() {return  textViewStats; }
}
