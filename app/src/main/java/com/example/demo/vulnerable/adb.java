package com.example.demo.vulnerable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class adb extends AppCompatActivity {

    EditText user,pwd;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adb);

        user=(EditText)findViewById(R.id.adb_user);
        pwd=(EditText) findViewById(R.id.adb_pwd);
        submit=(Button)findViewById(R.id.adb_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((user.getText()).toString()).equals("admin") && ((pwd.getText()).toString()).equals("admin")){
                    Intent i=new Intent(adb.this,Congrats.class);
                    i.putExtra("adb","Activity");
                    startActivity(i);
                }
            }
        });
    }
}
