package com.example.demo.vulnerable;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android  .view.ActionMode;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Copy_Paste extends AppCompatActivity {

    EditText input;
    Button go;
    String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy__paste);
        input=(EditText)findViewById(R.id.paste);
        go=(Button)findViewById(R.id.go1);

        ClipboardManager cl= (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip=ClipData.newPlainText("plain text",getString(R.string.paste));
        cl.setPrimaryClip(clip);
        Toast.makeText(Copy_Paste.this,"Plain text has been copied to Clipboard object",Toast.LENGTH_LONG).show();

        input.setCustomSelectionActionModeCallback(new ActionMode.Callback() {

            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode mode) {
            }

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               answer=(input.getText()).toString();



               if(answer.equals(getString(R.string.paste)))
               {
                   Toast.makeText(Copy_Paste.this,"Correct",Toast.LENGTH_LONG).show();
                   Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                   vibe.vibrate(300);
                   LayoutInflater inflater = (LayoutInflater)Copy_Paste.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                   View layout = inflater.inflate(R.layout.about, (ViewGroup)findViewById(R.id.root));
                   AlertDialog.Builder adb = new AlertDialog.Builder(Copy_Paste.this);
                   adb.setView(layout);
                   adb.show();
               }
               else
               {
                   Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                   vibe.vibrate(100);
                   Toast.makeText(Copy_Paste.this,"wrong,try again ",Toast.LENGTH_LONG).show();

               }

            }
        });



    }
}
