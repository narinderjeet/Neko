package com.example.demo.vulnerable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by narinds on 1/22/2018.
 */

public class Database2 extends SQLiteOpenHelper {

    public static final String db_name="MyDB.db";
    public static final String table_name="user1";
    public static final String user="username";
    public static final String pass="passsword";
//    public static final String password="password";

    public Database2(Context context) {
        super(context, db_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        db.execSQL(
//                "create table user1"+
//                        "(username text, password text)"
//        );
//        Log.d("Database2","heeloo");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user1");
        onCreate(db);
    }

    public boolean insert(String username, String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        try {
            db.delete("user1", null, null);
        }catch(Exception e){
            db.execSQL(
                    "create table user1"+
                            "(username text, password text)"
            );
        }
            cv.put("username",username);
            cv.put("password",password);
//        cv.put("password",password);
            db.insert("user1",null,cv);

        return true;
    }

    public Cursor getData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user1",null);
        return cursor;
    }

    public boolean check(String username, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user1 where username='"+username+"' and password='"+password+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()==0){
            return false;
        }
        return true;
    }
}
