package com.example.demo.vulnerable;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class Splash extends AppCompatActivity {

    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i = new Intent(Splash.this, FirstScreen.class);
                startActivity(i);
                finish();
            }
        }, 3000);

        GifImage gifImageView = (GifImage) findViewById(R.id.GifImage);
        gifImageView.setGifImageResource(R.mipmap.cat);

//        Glide.with(this).load()
    }
}
