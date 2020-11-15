package com.example.demo.vulnerable;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class screenshot extends AppCompatActivity {

    Button a1,a2,a11,a22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_screenshot);


        a1=(Button)findViewById(R.id.screen_a1);
        a2=(Button)findViewById(R.id.screen_a2);
        a11=(Button)findViewById(R.id.screen_a11);
        a22=(Button)findViewById(R.id.screen_a22);


        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(screenshot.this,activity1.class);
                startActivity(i);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(screenshot.this,activity2.class);
                startActivity(i);
            }
        });

        a11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(screenshot.this,"Testcase Passed",Toast.LENGTH_SHORT).show();
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(300);
                LayoutInflater inflater = (LayoutInflater)screenshot.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                AlertDialog.Builder adb = new AlertDialog.Builder(screenshot.this);
                adb.setView(layout);
                adb.show();
            }
        });

        a22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(screenshot.this,"Wrong answer",Toast.LENGTH_SHORT).show();
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(100);
            }
        });
    }
}
