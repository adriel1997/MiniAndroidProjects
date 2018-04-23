package com.example.adriealle.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {


    public Database(Context context) {
        super(context,"REG", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE REG ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_number TEXT, room TEXT, mail TEXT )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "REG");
        onCreate(db);
    }

    void addContact(String s, String n, String m, String l) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", s);
        values.put("phone_number", n);
        values.put("room", m);
        values.put("mail", l);
        db.insert("REG", null, values);
        db.close();


    }

}