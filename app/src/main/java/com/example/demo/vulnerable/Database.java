package com.example.demo.vulnerable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by narinds on 1/18/2018.
 */

public class Database extends SQLiteOpenHelper {

    public static final String db_name="MyDB.db";
    public static final String table_name="user";
    public static final String dataa="data";
//    public static final String password="password";

    public Database(Context context) {
        super(context, db_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public boolean insert(String data)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        try {
            db.delete("user", null, null);
        }catch(Exception e){
            db.execSQL(
                    "create table user"+
                            "(data text)"
            );
        }
        cv.put("data",data);
        db.insert("user",null,cv);
        return true;
    }

    public Cursor getData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user",null);
        return cursor;
    }

    public boolean update(String data)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("data",data);
//        cv.put("password",password);
        db.update("user",cv,null,null);
        return true;
    }
}
