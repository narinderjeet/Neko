package com.example.demo.vulnerable;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FirstScreen extends AppCompatActivity {

    Button m1,m2,m4,m5,m6,m7,m8,m9,m10;
//    ImageView credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        m1 = (Button) findViewById(R.id.m1head);
        m2 = (Button) findViewById(R.id.m2head);
        m4 = (Button) findViewById(R.id.m4head);
        m5 = (Button) findViewById(R.id.m5head);
        m6 = (Button) findViewById(R.id.m6head);
        m7 = (Button) findViewById(R.id.m7head);
        m8 = (Button) findViewById(R.id.m8head);
        m9 = (Button) findViewById(R.id.m9head);
        m10 = (Button) findViewById(R.id.m10head);
//        credits=(ImageView) findViewById(R.id.credits);
//
//        credits.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LayoutInflater inflater = (LayoutInflater) FirstScreen.this.getSystemService(LAYOUT_INFLATER_SERVICE);
//                View layout = inflater.inflate(R.layout.credits, (ViewGroup) findViewById(R.id.root));
//                AlertDialog.Builder adb = new AlertDialog.Builder(FirstScreen.this);
//                adb.setView(layout);
//                adb.setPositiveButton("Ok",null);
//                AlertDialog dialog=adb.create();
//                dialog.show();
//            }
//        });


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.myanimation);
//        image.startAnimation(animation);


        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"Support for vulnerable minimum OS version"};
//        Intent i=new Intent(this,MinOS.class);
//        i.putExtra("name",a);
                String[] a1 = {"M1.1"};
                String[] a2 = {"MinOS"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });


        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"Storing credentials in Shared Preferences", "Storing sensistive info unencrypted in local database"};
//        Intent i=new Intent(this,MinOS.class);
//        i.putExtra("name",a);
                String[] a1 = {"M2.1", "M2.2"};
                String[] a2 = {"SP", "sql"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"SQL injection in Login Activity", "Credentials stored in source code", "Credentials displayed in Logcat",
                        "Background Resume"};
                String[] a1 = {"M4.1", "M4.2", "M4.3", "M4.4"};
                String[] a2 = {"sql_injection", "Credential_Source", "Credential_logcat", "background"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });

        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"Key stored statically in source code", "No salt in AES256", "Password saved in /data/data/pkg in MD5 format"};
//        Intent i=new Intent(this,Secret_key_vuln.class);
//        i.putExtra("name",a);
                String[] a1 = {"M5.1", "M5.2", "M5.3"};
                String[] a2 = {"Secret_key_vuln", "SALT_AES", "Password_In_MD5"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });

        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"Invoking activity using ADB commands"};
//        Intent i=new Intent(this,MinOS.class);
//        i.putExtra("name",a);
                String[] a1 = {"M6.1"};
                String[] a2 = {"adb"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });

        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"Keeping secret in Logs", "NPI data leakage"};
//        Intent i=new Intent(this,MinOS.class);
//        i.putExtra("name",a);
                String[] a1 = {"M7.1", "M7.2"};
                String[] a2 = {"secret_in_Log", "NPI_Data_Leakage"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });

        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"Tampering code to bypass root detection"};
//        Intent i=new Intent(this,MinOS.class);
//        i.putExtra("name",a);
                String[] a1 = {"M8.1"};
                String[] a2 = {"rootBypass"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });

        m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"Proguard/Dexguard switched off"};
//        Intent i=new Intent(this,MinOS.class);
//        i.putExtra("name",a);
                String[] a1 = {"M9.1"};
                String[] a2 = {"proguard"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });

        m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] a = {"Allow Backup - true", "Debuggable - true", "Copy Paste Functionality", "Screenshot Leakage", "Sensitive Permissions"};
//        Intent i=new Intent(this,MinOS.class);
//        i.putExtra("name",a);
                String[] a1 = {"M10.1", "M10.2", "M10.3", "M10.4", "M10.5"};
                String[] a2 = {"Allow_Backup", "Debuggable", "Copy_Paste", "screenshot", "permissions"};
                Bundle b = new Bundle();
                b.putStringArray("name", a);
                Bundle b1 = new Bundle();
                b1.putStringArray("serial", a1);
                Bundle b2 = new Bundle();
                b2.putStringArray("activity", a2);
                Intent i = new Intent(FirstScreen.this, screen2.class);
                i.putExtras(b);
                i.putExtras(b1);
                i.putExtras(b2);
                startActivity(i);
            }
        });
    }
}
