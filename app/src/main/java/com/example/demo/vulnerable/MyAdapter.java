package com.example.demo.vulnerable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by narinds on 1/18/2018.
 */

public class MyAdapter extends BaseAdapter{
    private static LayoutInflater inflater=null;
    String[] array,array1;
    Context context;

    public MyAdapter(screen2 s, String[] array, String[] array1){
        this.array=array;
        this.array1=array1;
        context=s;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        TextView tv2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder=new Holder();
        View rowview;
        rowview=inflater.inflate(R.layout.list,null);
        holder.tv1=(TextView) rowview.findViewById(R.id.serial);
        holder.tv2=(TextView) rowview.findViewById(R.id.name);
        holder.tv1.setText(array[i]);
        holder.tv2.setText(array1[i]);
        return rowview;
    }
}
