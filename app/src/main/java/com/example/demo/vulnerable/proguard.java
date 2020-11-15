package com.example.demo.vulnerable;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class proguard extends AppCompatActivity {


    Button next;
    Button next1;
    Button done;
    TextView step;
    Button yes;
    Button no;
//    Button reset;
    TextView challenge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proguard);
        next=(Button)findViewById(R.id.next);
        next1=(Button)findViewById(R.id.next1);
        done =(Button)findViewById(R.id.done);
        yes=(Button)findViewById(R.id.true1);
        no=(Button)findViewById(R.id.false1);

        challenge=(TextView)findViewById(R.id.challenge);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step=(TextView)findViewById(R.id.step1);
                step.setText("2.Use jd-Gui to view java files");
                next.setVisibility(View.INVISIBLE);
                next1.setVisibility(View.VISIBLE);


            }
        });
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step=(TextView)findViewById(R.id.step1);
                step.setText("3.Verify whether the files are obfuscated or not!");
                next1.setVisibility(View.INVISIBLE);
                done.setVisibility(View.VISIBLE);

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                challenge.setVisibility(View.VISIBLE);

            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(proguard.this,"Sorry,Try again",Toast.LENGTH_LONG).show();
                Vibrator vibe=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);

            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(proguard.this,"CORRECT,YOU WIN",Toast.LENGTH_LONG).show();
                Vibrator vibe=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(300);
                LayoutInflater inflater = (LayoutInflater)proguard.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                AlertDialog.Builder adb = new AlertDialog.Builder(proguard.this);
                adb.setView(layout);
                adb.show();
            }
        });


    }


}
