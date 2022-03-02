package fr.iuttest.jeuandroid.views;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iuttest.jeuandroid.R;

public class FenetreParametre extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetre_parametre);
        mediaPlayer = MediaPlayer.create(this, R.raw.sound_test);

    }

    public void clickRetour(View view) {
        finish();
    }


    public void clickSoundTest(View view) {

        mediaPlayer.start();
    }

}
