package com.example.demo.vulnerable;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import pl.droidsonroids.gif.GifImageView;

public class Secret_key_vuln extends AppCompatActivity {

    EditText inputString;
    Button encrypt;
    TextView show;
    String output;
    String  AES="AES";
    int num;
    Random rm;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_key_vuln);
        inputString = (EditText) findViewById(R.id.inputText);
        show = (TextView) findViewById(R.id.textView);
        encrypt = (Button) findViewById(R.id.encrypt);
        rm=new Random();

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num=rm.nextInt(4)+1;
                    output=encryption(inputString.getText().toString(),num);
                    show.setText(output);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private String encryption(String s,int i) throws Exception {

        switch(i){

            case 1: password=getString(R.string.case1);
            break;
            case 2: password=getString(R.string.case2);
                break;
            case 3: password=getString(R.string.case3);
                break;
            case 4: password=getString(R.string.case4);
                break;

        }


        final MessageDigest digest=MessageDigest.getInstance("SHA-256");
        byte[] bytes= password.getBytes("UTF-8");
        digest.update(bytes,0,bytes.length);
        byte[] key=digest.digest();
        SecretKeySpec secret=new SecretKeySpec(key,"AES");
        SecretKeySpec mkey=secret;


        Cipher c=Cipher.getInstance(AES);
        c.init(Cipher.ENCRYPT_MODE,mkey);
        byte[] encrypted=c.doFinal(s.getBytes());
        String encryptedvalue= Base64.encodeToString(encrypted,Base64.DEFAULT);
        return encryptedvalue;
    }


    public  void go(View view)
    {

        EditText userinput=(EditText)findViewById(R.id.editText);

        String soYouFoundIt=userinput.getText().toString();
        if(soYouFoundIt.equals(password))
        {
            Toast.makeText(Secret_key_vuln.this,"Correct",Toast.LENGTH_LONG).show();

            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(300);
            LayoutInflater inflater = (LayoutInflater)Secret_key_vuln.this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
            AlertDialog.Builder adb = new AlertDialog.Builder(Secret_key_vuln.this);
            adb.setView(layout);
            adb.show();

        }
        else
        {
            Toast.makeText(Secret_key_vuln.this,"Sorry,Try again",Toast.LENGTH_LONG).show();
            Vibrator vibe = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibe.vibrate(100);


        }
    }
}
