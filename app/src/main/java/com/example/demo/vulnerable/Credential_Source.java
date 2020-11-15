package com.example.demo.vulnerable;

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

public class Credential_Source extends AppCompatActivity {


    EditText name;
    EditText pass;
    Button login;
    String USER_NAME;
    String USER_PASS;
//    String username;
//    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credential__source);

        name=(EditText)findViewById(R.id.entername);
        pass=(EditText)findViewById(R.id.passInput);
        login=(Button)findViewById(R.id.login);
         USER_NAME=getString(R.string.User_name_cred);
         USER_PASS=getString(R.string.User_pass_cred);

//         username=name.getText().toString();
//         password=pass.getText().toString();

         login.setOnClickListener(new View.OnClickListener() {
             @Override

             public void onClick(View v) {
                 if((name.getText().toString()).equals(USER_NAME) && (pass.getText().toString()).equals(USER_PASS)) {
                     Toast.makeText(Credential_Source.this, "Correct", Toast.LENGTH_LONG).show();
                     Vibrator vibe=(Vibrator)getSystemService(VIBRATOR_SERVICE);
                     vibe.vibrate(300);
                     LayoutInflater inflater = (LayoutInflater)Credential_Source.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                     View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                     AlertDialog.Builder adb = new AlertDialog.Builder(Credential_Source.this);
                     adb.setView(layout);
                     adb.show();

                 }
                 else
//                 {      Toast.makeText(Credential_Source.this,""+, Toast.LENGTH_LONG).show();
                 {
                     Toast.makeText(Credential_Source.this, "Sorry,Try again", Toast.LENGTH_LONG).show();
                     Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                     vibe.vibrate(100);
                 }

                 }


         });

    }




}
