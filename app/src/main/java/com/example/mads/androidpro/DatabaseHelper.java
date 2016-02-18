package com.example.mads.androidpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*
https://www.youtube.com/watch?v=cp2rL3sAFmI - klassen er lavet på baggrund af denne tutorial (serie)
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "User.db"; // navnet på filen der bliver gemt på enheden
    public static final String TABLE_NAME = "User_table"; // tabellens navn - indeholder alt data + kollonner selvfølgelig

    public static final String COL_1 = "ID"; // angiver kollonner og navne
    public static final String COL_2 = "NAME";

    /*
    onCreate, onUpgrade og konstruktøren er et krav når en klasse extender sqliteopenhelper
    metoderne kan genreeres automatisk.
    Sql er ikke "case-sensitive"
     */

    public DatabaseHelper(Context context) { // kontruktør hvis du skulle være i tvivl
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
        Long result  = db.insert(TABLE_NAME, null, contentValues); // db.insert retuenrer -1 hvis handlingen ikke kunne lade sig gøre
        if(result == -1){
            return false;
        }
        else {
            return true;
        }

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,id);
        contentValues.put(COL_2, name);

        db.update(TABLE_NAME, contentValues, "id = ?", new String[] {id});
        return true;
    }
/*
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "");

    }
*/
    
}
