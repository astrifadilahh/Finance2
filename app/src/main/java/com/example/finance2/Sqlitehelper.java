package com.example.finance2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlitehelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "finance";
    private static final String TABLE_NAME = "user";
    private static final String ID = "id";
    private static final String FIRST = "first";
    private static final String LAST = "last";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table user" +
            "(id integer primary key not null," +
            "first text not null," +
            "last text not null," +
            "email text not null," +
            "password text not null);";

    public Sqlitehelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertKontak(Kontak k){
        db = this.getWritableDatabase();
        String query = "select * from user ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        ContentValues values = new ContentValues();
        values.put(ID, count);
        values.put(FIRST, k.getFirst());
        values.put(LAST, k.getLast());
        values.put(EMAIL, k.getEmail());
        values.put(PASSWORD, k.getPass());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String email){
        db=this.getReadableDatabase();
        String query = "select email, password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if (a.equals(email)){
                b = cursor.getString(1);
                break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
