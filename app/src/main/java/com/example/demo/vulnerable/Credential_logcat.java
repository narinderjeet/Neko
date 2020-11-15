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

public class Credential_logcat extends AppCompatActivity {

    EditText userinput;
    Button gen;
    Button go;
    String Cardno;
    String Input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credential_logcat);

        userinput=(EditText)findViewById(R.id.EnterCred);
        go=(Button)findViewById(R.id.go);
        gen=(Button)findViewById(R.id.generate);
        userinput=(EditText)findViewById(R.id.EnterCred);



        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(Credential_logcat.this,"Credit card number generated",Toast.LENGTH_LONG).show();
                    Cardno = getString(R.string.Cred);
                    Log.d("User card number", Cardno);
                    Log.d("Not secured", "Developer can make functionalities to Log anything without user's Knowledge,HAHA");

            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Input=userinput.getText().toString();
                if(Input.equals(Cardno))
                {


                    Toast.makeText(Credential_logcat.this,"Correct ",Toast.LENGTH_LONG).show();
                    Vibrator vibe=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(300);
                    LayoutInflater inflater = (LayoutInflater)Credential_logcat.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                    View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                    AlertDialog.Builder adb = new AlertDialog.Builder(Credential_logcat.this);
                    adb.setView(layout);
                    adb.show();
                }
                else
                {

                    Toast.makeText(Credential_logcat.this,"Sorry try again",Toast.LENGTH_LONG).show();
                    Vibrator vibe=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);


                }
            }
        });
    }


}
