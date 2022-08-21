package com.example.medic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    public dbhelper(Context context) {
        super(context, "mydb", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table chk(Name text,Email text,Mobno text,Pass text)");

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists chk");
        onCreate(sqLiteDatabase);
    }

    public boolean insert(String Name, String Email, String Mobno, String Pass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("sname", Name);
        c.put("semail", Email);
        c.put("smobno", Mobno);
        c.put("spass", Pass);
        if (db.insert("chk", null, c) == -1) {
            return true;
        }
        return false;
    }

    public Cursor fetch(String email) {
        SQLiteDatabase db = getReadableDatabase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from chk where email='");
        stringBuilder.append(email);
        stringBuilder.append("'");
        return db.rawQuery(stringBuilder.toString(), null);
    }

    public boolean existing(String email) {
        if(getWritableDatabase().rawQuery("select email from tables where email=?",new String[]{email}).getCount()>0){
          return true;
        }
        return false;
    }
}
