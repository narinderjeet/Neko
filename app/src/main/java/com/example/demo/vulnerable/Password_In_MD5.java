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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import pl.droidsonroids.gif.GifImageView;

public class Password_In_MD5 extends AppCompatActivity {

    EditText uname;
    EditText password;
    TextView buck;
    String Hashtext;
    String MD5="MD5";
    String userpasshashed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password__in__md5);
        uname=(EditText)findViewById(R.id.DebitInput);
        password=(EditText)findViewById(R.id.passInput);

    }

    public  String encrypt(String s) throws NoSuchAlgorithmException {

        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            byte[] messagedigest=md.digest(s.getBytes());
            BigInteger number=new BigInteger(1,messagedigest);
            Hashtext=number.toString(16);
            while(Hashtext.length()<32)
            {
                Hashtext="0"+Hashtext;
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  Hashtext;

    }


    public void save(View view) throws NoSuchAlgorithmException {
        String pass=password.getText().toString();
        String user=uname.getText().toString();
        String combination=pass+user;
        String  Hashed=encrypt(combination);

        SharedPreferences sharedpref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpref.edit();
        editor.putString("user + password",Hashed);
        editor.apply();
        Toast.makeText(this,"SAVED SUCESSFULLY",Toast.LENGTH_LONG).show();

        userpasshashed=sharedpref.getString("user + password","");

    }



    public void go(View view)
    {
        EditText challenge=(EditText)findViewById(R.id.ChallengeInput);
        String challengeip=challenge.getText().toString();

        if(challengeip.equals(userpasshashed))
        {
            Toast.makeText(this,"CORRECT",Toast.LENGTH_LONG).show();


            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(300);
            LayoutInflater inflater = (LayoutInflater)Password_In_MD5.this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
            AlertDialog.Builder adb = new AlertDialog.Builder(Password_In_MD5.this);
            adb.setView(layout);
            adb.show();
        }
        else
        {
            Toast.makeText(this,"Sorry,Try again ",Toast.LENGTH_LONG).show();
            Vibrator vibe=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            vibe.vibrate(100);



        }


    }
}
