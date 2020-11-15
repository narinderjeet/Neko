package com.example.demo.vulnerable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class screen2 extends AppCompatActivity {

    ListView lv;
    AdapterView av;
    String[] serial;
    String[] name;
    String[] activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        Bundle b=this.getIntent().getExtras();
        name=b.getStringArray("name");

        Bundle b1=this.getIntent().getExtras();
        serial=b1.getStringArray("serial");

        Bundle b2=this.getIntent().getExtras();
        activity=b2.getStringArray("activity");

        lv=(ListView)findViewById(R.id.list);

        final MyAdapter adapter=new MyAdapter(screen2.this,serial,name);
        lv=(ListView)findViewById(R.id.list);
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


            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    try {
                        Intent j = new Intent(screen2.this, Class.forName("com.example.demo.vulnerable."+activity[i]));
                        startActivity(j);
                    }catch(Exception e){
                        Log.d("Firstscreen",e.toString());
                    }
                }
            });
    }
}
