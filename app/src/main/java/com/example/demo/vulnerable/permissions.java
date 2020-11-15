package com.example.demo.vulnerable;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static com.example.demo.vulnerable.Adapter2.al;

public class permissions extends AppCompatActivity {

    ListView lv;
    AdapterView av;
    String[] name={"Access Location Extra Commands", "Access Network State", "Access Notification Policy",
    "Access Wifi State","Bluetooth","Bluetooth Admin","Broadcast Sticky","Change Network state","Change Wifi Multicast State",
    "Change Wifi State","Disable Keyguard", "Expand Status Bar","Get PAckage Size","Install Shortcut","Intenet",
    "Kill Background Process","Modify Audio Settings","NFC","Read Sync Settings","Read Sync Status","Receive Boot Completed",
    "Reorder Tasks","Request Ignore Battery Optimizations","Request Install Packages","Set Alarm","Set Time Zone",
    "Write External Storage","Set Wallpaper Hints","Transmit IR","Uninstall Shortcut","Use Fingerprint","Vibrate","Wake Lock",
    "Write Sync Settings"};
    CheckBox check;
    ArrayList<Integer> a;
    Button submit,submit1;
    EditText external;
    private static final int PERMISSION_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        a=new ArrayList<Integer>();
        check=(CheckBox)findViewById(R.id.permisssion_check);
        submit=(Button)findViewById(R.id.permissions_submit);
        external=(EditText)findViewById(R.id.permissions_external);
        submit1=(Button)findViewById(R.id.permissions_external_submit);

        final Adapter2 adapter=new Adapter2(permissions.this,name);
        lv=(ListView)findViewById(R.id.permissions_list);
        lv.setAdapter(adapter);

        int totalHeight=0;

        for (int j = 0; j < adapter.getCount(); j++) {
            View mView = adapter.getView(j, null, lv);

            mView.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),

                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

            totalHeight += mView.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = lv.getLayoutParams();
        params.height = totalHeight
                + (lv.getDividerHeight() * (adapter.getCount() - 1));
        lv.setLayoutParams(params);
        lv.requestLayout();


        if(CheckPermission()) {
            String path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "Abc.txt";
            File file = new File(path);
            if (!file.exists()) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                    writer.write(getString(R.string.externalStorage));
                    writer.close();

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(permissions.this, "" + e.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        }
        else{
            RequestPermission();
        }



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Collections.sort(al);

                String a[]=al.toArray(new String[al.size()]);
                int[] a1=new int[a.length];
                for(int i=0;i<a.length;i++){
                    a1[i]=Integer.parseInt(a[i]);
                }
                Arrays.sort(a1);
                String s="";
                for(int i=0;i<a1.length;i++){
                    s=s.concat(""+a1[i]);
                }
                String s1="0347141924263133";
                if(s.equals(s1)) {
                    Toast.makeText(permissions.this, "Testcase passed", Toast.LENGTH_SHORT).show();
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(500);
                    LayoutInflater inflater = (LayoutInflater)permissions.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                    View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                    AlertDialog.Builder adb = new AlertDialog.Builder(permissions.this);
                    adb.setView(layout);
                    adb.show();
                }
                else {
                    Toast.makeText(permissions.this, "Try again", Toast.LENGTH_SHORT).show();
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(100);
                }
            }
        });

        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckPermission()) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "Abc.txt"));
                        if ((reader.readLine()).equals((external.getText()).toString())) {
                            Toast.makeText(permissions.this, "Testcase Passed", Toast.LENGTH_SHORT).show();
                            Vibrator v1 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            v1.vibrate(300);
                            LayoutInflater inflater = (LayoutInflater) permissions.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                            View layout = inflater.inflate(R.layout.about, (ViewGroup) findViewById(R.id.root));
                            AlertDialog.Builder adb = new AlertDialog.Builder(permissions.this);
                            adb.setView(layout);
                            adb.show();
                        } else {
                            Toast.makeText(permissions.this, "Try again", Toast.LENGTH_SHORT).show();
                            Vibrator v1 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            v1.vibrate(100);
                        }
                        reader.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(permissions.this, "" + e.toString(), Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    RequestPermission();
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

    @Override
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
        new AlertDialog.Builder(permissions.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .create()
                .show();
    }

}
