package fr.iuttest.jeuandroid.views;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;

public class FenetrePrincipal extends AppCompatActivity {

    private TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_principal);
        textView = findViewById(R.id.textView);
    }

    public void clickJouer(View view) {
        textView.setText(R.string.Jouer);
    }

    public void clickParametre(View view) {
        textView.setText(R.string.Paramètre);
    }

    public void clickQuitter(View view) {
        finish();
    }
}
