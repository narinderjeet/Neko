package com.example.demo.vulnerable;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Debuggable extends AppCompatActivity {

    int i,k;
    Button press;
    Button correct;
    Button wrong;
    RelativeLayout challenge;
    private static final int PERMISSION_REQUEST_CODE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debuggable);
        press=(Button)findViewById(R.id.press);
        challenge=(RelativeLayout)findViewById(R.id.challenge_screen);
        wrong=(Button)findViewById(R.id.wrong);
        correct=(Button)findViewById(R.id.correct);
        Toast.makeText(Debuggable.this,"Only works on NON-ROOTED devices",Toast.LENGTH_LONG).show();
        i=0;
        k=0;
        challenge.setVisibility(View.INVISIBLE);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                try {

                       RequestPermission();

                    checkRoot();

                    if (i != 0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Debuggable.this);
                        builder.setMessage("The Challenge will not run on Rooted devices .Do you want to close this application ?")
                                .setCancelable(false)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        System.exit(0);
                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.setTitle("Root detected");
                        alert.show();
                    }
                    else {

                        Toast.makeText(Debuggable.this,"Only works on Non-Rooted Devices",Toast.LENGTH_SHORT).show();
                        challenge.setVisibility(View.VISIBLE);

                        correct.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Debuggable.this,"Correct",Toast.LENGTH_LONG).show();
                                Vibrator vibe=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                                vibe.vibrate(300);


                                LayoutInflater inflater = (LayoutInflater)Debuggable.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                                View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                                AlertDialog.Builder adb = new AlertDialog.Builder(Debuggable.this);
                                adb.setView(layout);
                                adb.show();
                            }
                        });

                        wrong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Debuggable.this,"Sorry,try again",Toast.LENGTH_LONG).show();
                                Vibrator vibe=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                                vibe.vibrate(100);

                            }
                        });







                    }
                }
                    catch(Exception e){
                        Log.d("Build.prop", e.toString());
                        Toast.makeText(Debuggable.this,e.toString(),Toast.LENGTH_LONG).show();

                    }


                }
        });
        }

    protected boolean CheckPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }


    protected void RequestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);

    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean writeAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean readAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (writeAccepted && readAccepted) {
//                        Snackbar.make(view, "Permission Granted, Now you can access location data and camera.", Snackbar.LENGTH_LONG).show();
                        return;
                    }
                    else {

//                        Snackbar.make(view, "Permission Denied, You cannot access location data and camera.", Snackbar.LENGTH_LONG).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) {
                                showMessageOKCancel("Permission is required to run the activity successfully",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE},
                                                            PERMISSION_REQUEST_CODE);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
        }
    }


    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(Debuggable.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .create()
                .show();
    }



    public void checkRoot() {

        try {

//        FileReader fr = new FileReader("/system/build.prop");
//        BufferedReader br = new BufferedReader(fr);
//        String line = br.readLine();
//        while (line != null) {
////                Log.d("Number",""+(++j)+line);
//            if (line.equals("ro.build.tags=release-keys")) {
//                k++;
////                    Toast.makeText(rootBypass.this,"release keys",Toast.LENGTH_SHORT).show();
//                break;
//            } else {
//                line = br.readLine();
//            }
//        }
//        if (k == 0) {
//            i++;
////                        Toast.makeText(rootBypass.this,"release keys",Toast.LENGTH_SHORT).show();
//
//        }


            File file = new File("/etc/security/otacerts.zip");
            if (!file.exists()) {
                i++;
//                        Toast.makeText(rootBypass.this,"Superuser",Toast.LENGTH_SHORT).show();
            }

            file = new File("/system/app/superuser.apk");
            if (file.exists()) {
                i++;
//                        Toast.makeText(rootBypass.this,"Superuser",Toast.LENGTH_SHORT).show();
            }

            file = new File("/system/bin/su");
            if (file.exists()) {
                i++;
//                        Toast.makeText(rootBypass.this,"su",Toast.LENGTH_SHORT).show();
            }

            file = new File("/system/xbin/su");
            if (file.exists()) {
                i++;
//                        Toast.makeText(rootBypass.this,"su",Toast.LENGTH_SHORT).show();
            }

            file = new File("/sbin/su");
            if (file.exists()) {
                i++;
//                        Toast.makeText(rootBypass.this,"su",Toast.LENGTH_SHORT).show();
            }

            file = new File("/system/su");
            if (file.exists()) {
                i++;
//                        Toast.makeText(rootBypass.this,"su",Toast.LENGTH_SHORT).show();
            }

            file = new File("/system/bin/.ext/.su");
            if (file.exists()) {
                i++;
//                        Toast.makeText(rootBypass.this,"su",Toast.LENGTH_SHORT).show();
            }

            file = new File("/system/xbin/mu");
            if (file.exists()) {
                i++;
//                        Toast.makeText(rootBypass.this,"su",Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e)

        {
            e.printStackTrace();
//        Toast.makeText(Allow_Backup.this,e.toString(),Toast.LENGTH_SHORT).show();

        }
    }









    }



