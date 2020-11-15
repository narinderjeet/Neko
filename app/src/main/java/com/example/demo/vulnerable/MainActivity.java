package com.example.demo.vulnerable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button shared,sql,screen2,sql_injection,background,adb,permissions,screen,root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        shared=(Button)findViewById(R.id.sp);
        sql=(Button)findViewById(R.id.sql);
        screen2=(Button)findViewById(R.id.screen2);
        sql_injection=(Button)findViewById(R.id.sql_injection);
        background=(Button)findViewById(R.id.background);
        adb=(Button)findViewById(R.id.adb);
        permissions=(Button)findViewById(R.id.permissions);
        screen=(Button)findViewById(R.id.screenshot);
        root=(Button)findViewById(R.id.root);



        shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,SP.class);
                startActivity(m1);
            }
        });

        sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,sql.class);
                startActivity(m1);
            }
        });

        screen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,screen2.class);
                startActivity(m1);
            }
        });

        sql_injection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,sql_injection.class);
                startActivity(m1);
            }
        });

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,background.class);
                startActivity(m1);
            }
        });

        adb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,adb.class);
                startActivity(m1);
            }
        });

        permissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,permissions.class);
                startActivity(m1);
            }
        });

        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,screenshot.class);
                startActivity(m1);
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1=new Intent(MainActivity.this,rootBypass.class);
                startActivity(m1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
