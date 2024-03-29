package com.marv.cararena;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Bundle;

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
                },1200);


    }
}
