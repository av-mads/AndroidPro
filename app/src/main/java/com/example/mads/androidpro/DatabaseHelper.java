package com.example.mads.androidpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*
https://www.youtube.com/watch?v=cp2rL3sAFmI - klassen er lavet på baggrund af denne tutorial
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "User_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
//    public static final String COL_3 = "VISIT";

    /*
    onCreate, onUpgrade og konstruktøren er et krav når en klasse extender sqliteopenhelper
    metoderne kan genreeres automatisk.
    Sql er ikke "case-sensitive"
     */

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
 //       SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        Long result  = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }

    }
}
