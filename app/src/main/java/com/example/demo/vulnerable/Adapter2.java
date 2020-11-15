package com.example.demo.vulnerable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by narinds on 1/24/2018.
 */

public class Adapter2 extends BaseAdapter{
    private static LayoutInflater inflater=null;
    String[] array;
    Context context;
    static LinkedList<String> al;

    public Adapter2(permissions s, String[] array){
        this.array=array;
        context=s;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        al=new LinkedList<String>();
    }


    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder{
        TextView tv1;
        CheckBox c1;

    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final Holder holder=new Holder();
        View rowview;
        rowview=inflater.inflate(R.layout.list2,null);
        holder.tv1=(TextView) rowview.findViewById(R.id.permission_name);
        holder.c1=(CheckBox) rowview.findViewById(R.id.permisssion_check);
        holder.tv1.setText(array[i]);
        holder.c1.setChecked(false);

        rowview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d("Adapter2","Working");
//                Holder h=new Holder();
                if(holder.c1.isChecked()){
//                    Log.d("Adapter2","Working");
                    holder.c1.setChecked(false);
//                    if(al.contains(i))
                    al.remove(""+i);
                    Log.d("adapter2","remove");
                }
                else{
                    holder.c1.setChecked(true);
                    al.add(""+i);
                    Log.d("adadpter2","add");
                }
            }
        });
        return rowview;
    }
}