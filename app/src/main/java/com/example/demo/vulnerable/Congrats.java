package com.example.demo.vulnerable;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;

public class Congrats extends AppCompatActivity {

    Button redirect;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        text=(TextView)findViewById(R.id.congrats_text);

        String abc="";
        try {
            abc = getIntent().getExtras().getString("adb");
            text.setText("Textcase not passed. Try to run without Login Screen.");
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }catch(Exception e){
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(300);
            text.setText("Congratulations. You passed the testcase.");
            LayoutInflater inflater = (LayoutInflater)Congrats.this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
            AlertDialog.Builder adb = new AlertDialog.Builder(Congrats.this);
            adb.setView(layout);
            adb.show();
        }


//        if(Intent.hasExtra("adb")){
//            text.setText("Congratulations. You passed the testcase.");
//        }
//        else{
//            text.setText("Textcase not passed. Try to run without Login Screen.");
//        }

//        try {
//            j++;
//            Thread.sleep(2000);
//            Intent intent = new Intent(Congrats.this, adb.class);
//            startActivity(intent);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }
}
