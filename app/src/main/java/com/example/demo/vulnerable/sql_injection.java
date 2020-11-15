package com.example.demo.vulnerable;

import android.content.Context;
import android.database.Cursor;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sql_injection extends AppCompatActivity {

    EditText username, password, username2, password2;
    Button submitUP, submitSQL;
    Database2 db;
    TextView success, enterSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_injection);

        username = (EditText) findViewById(R.id.sql_injection_username);
        password = (EditText) findViewById(R.id.sql_injection_password);
        username2 = (EditText) findViewById(R.id.sql_injection_username2);
        password2 = (EditText) findViewById(R.id.sql_injection_password2);
        submitUP = (Button) findViewById(R.id.sql_injection_submitUP);
        submitSQL = (Button) findViewById(R.id.submitSQL_injection);
        db = new Database2(this);
//        success=(TextView) findViewById(R.id.successSQL_injection);
        enterSQL=(TextView) findViewById(R.id.enterSQL_injection);


//        success.setVisibility(View.INVISIBLE);

        submitUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((username.getText()).toString()).length() > 0 && ((password.getText()).toString()).length() > 0) {

                    if(db.insert((username.getText()).toString(), (password.getText()).toString())){
                        Toast.makeText(sql_injection.this,"Values have been saved",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(sql_injection.this,"Database error",Toast.LENGTH_SHORT).show();
                    }
                    enterSQL.setVisibility(View.VISIBLE);
                    username2.setVisibility(View.VISIBLE);
                    password2.setVisibility(View.VISIBLE);
                    submitSQL.setVisibility(View.VISIBLE);
//                    success.setVisibility(View.INVISIBLE);
                }
                else
                {
                    Toast.makeText(sql_injection.this,"Enter text in both the fields",Toast.LENGTH_SHORT).show();
                    Vibrator v=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(100);
                }
            }
        });

        submitSQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (((username2.getText()).toString()).length() != 0 && ((password2.getText()).toString()).length() != 0
                            && ((username.getText()).toString()).length() != 0 && ((password.getText()).toString()).length() != 0) {

                        if (db.check((username2.getText()).toString(), (password2.getText()).toString())) {
                            Toast.makeText(sql_injection.this, "Testcase Passed", Toast.LENGTH_LONG).show();
                            enterSQL.setVisibility(View.INVISIBLE);
                            username2.setVisibility(View.INVISIBLE);
                            password2.setVisibility(View.INVISIBLE);
                            submitSQL.setVisibility(View.INVISIBLE);
//                        success.setVisibility(View.VISIBLE);
                            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            v.vibrate(300);
                            LayoutInflater inflater = (LayoutInflater) sql_injection.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                            View layout = inflater.inflate(R.layout.about, (ViewGroup) findViewById(R.id.root));
                            AlertDialog.Builder adb = new AlertDialog.Builder(sql_injection.this);
                            adb.setView(layout);
                            adb.show();

                        } else {
                            Toast.makeText(sql_injection.this, "Try again", Toast.LENGTH_LONG).show();
                            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            v.vibrate(100);
                        }
                    } else {
                        Toast.makeText(sql_injection.this, "Enter all the fields", Toast.LENGTH_LONG).show();
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        v.vibrate(100);
                    }
                }catch(Exception e){
                    Toast.makeText(sql_injection.this,"Query error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
