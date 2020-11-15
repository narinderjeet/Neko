package com.example.demo.vulnerable;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class background extends AppCompatActivity {

    TextView timer;
    Button start,stop,yes,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        timer=(TextView)findViewById(R.id.background_timer);
        start=(Button)findViewById(R.id.background_start);
        stop=(Button)findViewById(R.id.background_stop);
        yes=(Button)findViewById(R.id.background_yes);
        no=(Button)findViewById(R.id.background_no);

//        check=(Button)findViewById(R.id.background_check);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(background.this,"Started",Toast.LENGTH_SHORT).show();
                startService(new Intent(getBaseContext(), Timer.class));
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(background.this,"Stopped",Toast.LENGTH_SHORT).show();
                stopService(new Intent(getBaseContext(), Timer.class));
//                t.stop();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(300);
                Toast.makeText(background.this,"Correct",Toast.LENGTH_SHORT).show();
                LayoutInflater inflater = (LayoutInflater)background.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                AlertDialog.Builder adb = new AlertDialog.Builder(background.this);
                adb.setView(layout);
                adb.show();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(100);
                Toast.makeText(background.this,"Incorrect",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
