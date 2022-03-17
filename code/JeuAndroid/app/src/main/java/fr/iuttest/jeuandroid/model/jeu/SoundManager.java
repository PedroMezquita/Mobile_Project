package fr.iuttest.jeuandroid.model.jeu;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import fr.iuttest.jeuandroid.R;

public class SoundManager {
    private MediaPlayer sound;

    public SoundManager(Context context, int name){
        sound = MediaPlayer.create(context, name);
    }


    public void start(){
        sound.start();
    }

}
