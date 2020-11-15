package com.example.demo.vulnerable;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Timer extends Service {
    static int i=0;
    int j;
//    Thread t;
    MediaPlayer player;

    public Timer() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);

        player.start();

        return START_STICKY;
    }


    public int check(){
        return i;
    }

    @Override
    public void onDestroy(){
        player.stop();
        super.onDestroy();
//        j++;
//        Toast.makeText(this,"Service stopped",Toast.LENGTH_SHORT).show();
    }
}
