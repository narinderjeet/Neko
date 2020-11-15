package com.example.demo.vulnerable;

import android.content.Context;
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
import android.widget.Toast;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class secret_in_Log extends AppCompatActivity {

    String ssn;
    Button generate;
    Button go;
    EditText enterssn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_in__log);
        generate=(Button)findViewById(R.id.generate);
        go=(Button)findViewById(R.id.go);
        enterssn=(EditText)findViewById(R.id.EnterCred);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(secret_in_Log.this,"SSN generated",Toast.LENGTH_LONG).show();

                Random rm=new Random();
                int min=100000000;
                int max=999999999;
                int  SSN=rm.nextInt(( max - min ) + 1) + min;
                ssn=String.valueOf(SSN);
                Log.d("SSN",ssn);
                Log.d("not secure","DEVELOPER CAN INTENTIONALLY LOG USERS IMPORTANT CREDENTIALS");

            }
        });


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String entered=enterssn.getText().toString();
                if(entered.equals(ssn))
                {
                    Toast.makeText(secret_in_Log.this,"Correct you win",Toast.LENGTH_LONG).show();
//            GifImageView img=(GifImageView)findViewById(R.id.tick);
//            img.setVisibility(View.VISIBLE);
                    Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(300);
                    LayoutInflater inflater = (LayoutInflater)secret_in_Log.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                    View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                    AlertDialog.Builder adb = new AlertDialog.Builder(secret_in_Log.this);
                    adb.setView(layout);
                    adb.show();
                }
                else
                {
                    Toast.makeText(secret_in_Log.this,"Sorry,try again",Toast.LENGTH_LONG).show();
                    Vibrator vibe=(Vibrator) getApplicationContext().getSystemService(VIBRATOR_SERVICE);
                    vibe.vibrate(100);



                }
            }
        });
    }




}
