package com.marvin.cararenaa.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;

import com.marvin.cararenaa.MainActivity;
import com.marvin.cararenaa.R;

public class SplashScreen extends Activity {
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run(){
                        Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },2500);

//        MediaPlayer mediaPlayer= MediaPlayer.create(SplashScreen.this,R.raw.burnout);
//        mediaPlayer.start();
    }
}
