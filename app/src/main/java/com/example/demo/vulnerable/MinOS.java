package com.example.demo.vulnerable;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class MinOS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_os);
    }

    public void OnClickGo(View view) {
        EditText osname = (EditText) findViewById(R.id.editText2);

        String entered = osname.getText().toString();

        if (entered.equals("14")) {
            Toast.makeText(this,"CORRECT,YOU WIN",Toast.LENGTH_LONG).show();


            Vibrator vibe = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibe.vibrate(300);
            LayoutInflater inflater = (LayoutInflater)MinOS.this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
            AlertDialog.Builder adb = new AlertDialog.Builder(MinOS.this);
            adb.setView(layout);
            adb.show();
        } else {
            Toast.makeText(MinOS.this, "Sorry Try again", Toast.LENGTH_LONG).show();
            Vibrator vibe = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibe.vibrate(100);



        }
    }
}
