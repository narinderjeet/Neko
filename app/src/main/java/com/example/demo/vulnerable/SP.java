package com.example.demo.vulnerable;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SP extends AppCompatActivity {

    EditText username,password,textSP;
    Button submitUP,submitSP;
    String up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        textSP=(EditText)findViewById(R.id.textSP);
        submitUP=(Button)findViewById(R.id.submitUP);
        submitSP=(Button)findViewById(R.id.submitSP);


        submitUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((username.getText()).toString()).length()>=4 && ((password.getText()).toString()).length()>=4) {
                    up = ((username.getText()).toString()).substring(0, 4) + ((password.getText()).toString()).substring(0, 4);
                    SharedPreferences sharedPref = SP.this.getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putInt(getString(R.string.saved_high_score), newHighScore);
                    editor.putString("UP", up);
                    editor.commit();
                    Toast.makeText(SP.this, "Text has been saved", Toast.LENGTH_SHORT).show();
//                Toast.makeText(SP.this,""+username.getText()+password.getText(),Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(SP.this,"Minimum character length is 4",Toast.LENGTH_LONG).show();
                    Vibrator v=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(100);
                }
            }
        });

        submitSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((textSP.getText()).toString()).length()!=0 && ((username.getText()).toString()).length() != 0
                        && ((password.getText()).toString()).length() != 0) {
                    SharedPreferences sharedPref = SP.this.getPreferences(Context.MODE_PRIVATE);

                    if ((sharedPref.getString("UP", null)).toString().equals((textSP.getText()).toString())) {
                        Toast.makeText(SP.this, "You passed the testcase", Toast.LENGTH_SHORT).show();
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        v.vibrate(300);
                        LayoutInflater inflater = (LayoutInflater)SP.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                        View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                        AlertDialog.Builder adb = new AlertDialog.Builder(SP.this);
                        adb.setView(layout);
                        adb.show();
                    } else {
                        Toast.makeText(SP.this, "Try again", Toast.LENGTH_SHORT).show();
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        v.vibrate(100);
                    }
                }
                else if(((username.getText()).toString()).length()==0 || ((password.getText()).toString()).length()==0)
                {
                    Toast.makeText(SP.this,"Enter both username and password fields",Toast.LENGTH_LONG).show();
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(100);
                }
                else
                {
                    Toast.makeText(SP.this,"Enter the text",Toast.LENGTH_LONG).show();
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(100);
                }

            }
        });

    }
}
