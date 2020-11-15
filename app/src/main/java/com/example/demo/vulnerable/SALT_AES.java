package com.example.demo.vulnerable;

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

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SALT_AES extends AppCompatActivity {
    Button encrypt;
    TextView show;
    String output;
    String  AES="AES";
    EditText inputString;
//    GifImageView tick;
    Button no;
    Button yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salt__aes);
        encrypt = (Button) findViewById(R.id.encrypt);
        inputString=(EditText)findViewById(R.id.inputText);
        show=(TextView) findViewById(R.id.textView);
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(SALT_AES.this,"Text Encrypted",Toast.LENGTH_LONG).show();
                    output=encryption(inputString.getText().toString());
                    show.setText(output);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        yes=(Button)findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SALT_AES.this,"Sorry,you are wrong",Toast.LENGTH_LONG).show();
        Vibrator vibe=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibe.vibrate(100);
//      tick.setVisibility(View.INVISIBLE);

            }
        });

        no=(Button)findViewById(R.id.go);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SALT_AES.this,"Correct,you win",Toast.LENGTH_LONG).show();
//                tick=(GifImageView)findViewById(R.id.tick);
                Vibrator vibe=(Vibrator)getSystemService(VIBRATOR_SERVICE);
                vibe.vibrate(300);
//                tick.setVisibility(View.VISIBLE);
                LayoutInflater inflater = (LayoutInflater)SALT_AES.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                AlertDialog.Builder adb = new AlertDialog.Builder(SALT_AES.this);
                adb.setView(layout);
                adb.show();

            }
        });
    }


    private String encryption(String s) throws Exception {

        String password=getString(R.string.case1);
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




//    protected void YES(View view)
//    {
//        Toast.makeText(SALT_AES.this,"Sorry,you are wrong",Toast.LENGTH_LONG).show();
//        Vibrator vibe=(Vibrator)getSystemService(VIBRATOR_SERVICE);
//        vibe.vibrate(100);
//        tick.setVisibility(View.INVISIBLE);
//    }





//    protected void NO(View view)
//    {
//        Toast.makeText(SALT_AES.this,"Correct,you win",Toast.LENGTH_LONG).show();
//        tick=(GifImageView)findViewById(R.id.tick);
//        tick.setVisibility(View.VISIBLE);
//
//    }
}
