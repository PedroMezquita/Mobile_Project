package fr.iuttest.jeuandroid.model.test;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.iuttest.jeuandroid.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public ViewHolder(@NonNull View itemView) {

        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.textView);;
    }

    public TextView getTextView() {
        return textView;
    }
}
