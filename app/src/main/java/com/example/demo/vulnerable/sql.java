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
import android.widget.Toast;

public class sql extends AppCompatActivity {

    EditText username, password, textSQL;
    Button submitUP, submitSQL;
    String up;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        username = (EditText) findViewById(R.id.sql_username);
        password = (EditText) findViewById(R.id.sql_password);
        textSQL = (EditText) findViewById(R.id.textSQL);
        submitUP = (Button) findViewById(R.id.sql_submitUP);
        submitSQL = (Button) findViewById(R.id.submitSQL);
        db = new Database(this);

        submitUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((username.getText()).toString()).length() >= 4 && ((password.getText()).toString()).length() >= 4) {
                    up = ((username.getText()).toString()).substring(0, 4) + ((password.getText()).toString()).substring(0, 4);

                    if(db.insert(up)){
                        Toast.makeText(sql.this,"Values have been saved",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(sql.this,"Database error",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(sql.this,"Minimum character length is 4",Toast.LENGTH_LONG).show();
                    Vibrator v=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(100);
                }
            }
        });

        submitSQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((textSQL.getText()).toString()).length() != 0 && ((username.getText()).toString()).length() != 0
                        && ((password.getText()).toString()).length() != 0) {
                    Cursor cursor=db.getData();
                    cursor.moveToFirst();

                  if(cursor.getString(cursor.getColumnIndex(Database.dataa)).equals((textSQL.getText()).toString())) {
                        Toast.makeText(sql.this, "Testcase Passed", Toast.LENGTH_LONG).show();
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        v.vibrate(300);

                        LayoutInflater inflater = (LayoutInflater)sql.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                        View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                        AlertDialog.Builder adb = new AlertDialog.Builder(sql.this);
                        adb.setView(layout);
                        adb.show();

                    }
                    else{
                        Toast.makeText(sql.this,"Try again",Toast.LENGTH_LONG).show();
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        v.vibrate(100);
                    }
                }
                else if(((username.getText()).toString()).length()==0 || ((password.getText()).toString()).length()==0)
                {
                    Toast.makeText(sql.this,"Enter both username and password fields",Toast.LENGTH_LONG).show();
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(100);
                }
                else
                {
                    Toast.makeText(sql.this,"Enter the text",Toast.LENGTH_LONG).show();
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(100);
                }
            }
        });

    }
}