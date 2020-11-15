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
import android.widget.Toast;

public class NPI_Data_Leakage extends AppCompatActivity {

    String Debit;
    String pass;
    String cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npi__data__leakage);
    }

    public void getdata()
    {
        EditText Debitcard=(EditText)findViewById(R.id.DebitInput);
        EditText Password=(EditText)findViewById(R.id.passInput);
        EditText CVV=(EditText)findViewById(R.id.cvvInput);

        Debit=Debitcard.getText().toString();
        pass=Password.getText().toString();
        cvv=CVV.getText().toString();


    }
    public void save(View view) {
       try {
           getdata();

           if(pass.length()<8)
           {
               Toast.makeText(this, "Password should consist of minimum 8 letters", Toast.LENGTH_LONG).show();

           }
            else {

               SharedPreferences shared = getSharedPreferences("user_info", MODE_PRIVATE);
               SharedPreferences.Editor EDITOR = shared.edit();
               EDITOR.putString("Debit card", Debit);
               EDITOR.putString("password", pass);
               EDITOR.putString("Debit card", cvv);
               Toast.makeText(this, "SAVED SUCESSFULLY", Toast.LENGTH_LONG).show();
           }

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }

    public void onyes(View view)
    {
        Toast.makeText(this,"WRONG ,YOU FAILED",Toast.LENGTH_LONG).show();
        Vibrator vibe=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(100);

    }
    public void onno(View view)
    {
        Toast.makeText(this,"CORRECT ,YOU WIN",Toast.LENGTH_LONG).show();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(300);
        LayoutInflater inflater = (LayoutInflater)NPI_Data_Leakage.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
        AlertDialog.Builder adb = new AlertDialog.Builder(NPI_Data_Leakage.this);
        adb.setView(layout);
        adb.show();
    }
}