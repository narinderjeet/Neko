package com.example.demo.vulnerable;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class rootBypass extends AppCompatActivity {

    TextView root;
    int i,k;
    Button start;
    private static final int PERMISSION_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_bypass);

        i=0;
        k=0;
        root=(TextView)findViewById(R.id.root_detected);
        start=(Button)findViewById(R.id.root_start);

//        root.setVisibility(View.VISIBLE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    rootCheck();
            }
        });

    }

    void rootCheck(){
        try {

            File file = new File("/etc/security/otacerts.zip");
            if (!file.exists()) {
                i++;
            }

        file = new File("/system/app/superuser.apk");
        if (file.exists()) {
            i++;
       }

        file = new File("/system/bin/su");
        if (file.exists()) {
            i++;
        }

        file = new File("/system/xbin/su");
        if (file.exists()) {
            i++;
        }

        file = new File("/sbin/su");
        if (file.exists()) {
            i++;
        }

        file = new File("/system/su");
        if (file.exists()) {
            i++;
        }

        file = new File("/system/bin/.ext/.su");
        if (file.exists()) {
            i++;
        }

        file = new File("/system/xbin/mu");
        if (file.exists()) {
            i++;
        }

        if (i != 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(rootBypass.this);
            builder.setMessage("The application cant work on a rooted device.Do you want to close this application ?")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            System.exit(0);
                        }
                    });

            AlertDialog alert = builder.create();
            alert.setTitle("Root detected");
            alert.show();
        } else {
            CountDownTimer cd = new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    root.setText("" + millisUntilFinished / 1000);
                    Log.d("abc", "" + millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    root.setText("Done!!");
                }
            }.start();

        }

    } catch (Exception e) {
        Log.d("Build.prop", e.toString());
        Toast.makeText(rootBypass.this, e.toString(), Toast.LENGTH_SHORT).show();
    }
    }

}
