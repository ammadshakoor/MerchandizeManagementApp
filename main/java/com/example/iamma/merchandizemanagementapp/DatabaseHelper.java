package com.example.iamma.merchandizemanagementapp;/* package name here */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper{

    // use the variable to make database
    public static final String DATABASENAME = "MerhcandizeSystem.db";
    // set database name MMS or etc..

    // create table VARAIABLES  ..
    public static final String LAPTOP = "laptop";
    // these are the attribute of the above table
    public static final String LAPTOP_COL1 = "LAPTOP_ID";
    public static final String LAPTOP_COL2 = "LAPTOP_ITEM_ID";
    public static final String LAPTOP_COL3 = "LAPTOP_NAME";
    public static final String LAPTOP_COL4 = "LAPTOP_TYPE";
    public static final String LAPTOP_COL5 = "LAPTOP_MANUFACTURE";
    public static final String LAPTOP_COL6 = "LAPTOP_MODEL";
    public static final String LAPTOP_COL7 = "LAPTOP_WEBPAGE";

    // class constructor with argument type context
    public DatabaseHelper(Context context) {
        super(context, DATABASENAME,null,1);

        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // execute query to make table in database
        db.execSQL("create table "  + LAPTOP + "(LAPTOP_ID INTEGER PRIMARY KEY AUTOINCREMENT, LAPTOP_ITEM_ID STRING, LAPTOP_NAME STRING ,LAPTOP_TYPE STRING, LAPTOP_MANUFACTURE STRING, LAPTOP_MODEL STRING, LAPTOP_WEBPAGE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop data
        db.execSQL("DROP TABLE IF EXISTS " + LAPTOP);
        onCreate(db);
    }

    // method to insert query on watch table
    public boolean InsertLaptop(String item_id,String name,String type,String manufacture,String model,String webpage)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(LAPTOP_COL2,item_id);
        contentValues1.put(LAPTOP_COL3,name);
        contentValues1.put(LAPTOP_COL4,type);
        contentValues1.put(LAPTOP_COL5,manufacture);
        contentValues1.put(LAPTOP_COL6,model);
        contentValues1.put(LAPTOP_COL7,webpage);

        long result = db.insert(LAPTOP, null,contentValues1);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Get Table Laptops Detail
    public ArrayList<HashMap<String,String>> GetLaptop(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String,String>> regList = new ArrayList<>();
        String query = "SELECT * FROM "+ LAPTOP;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext())
        {
            HashMap<String,String> reg = new HashMap<>();
          //  reg.put("LAPTOP_ITEM_ID",cursor.getString(cursor.getColumnIndex(LAPTOP_COL2)));
            reg.put("LAPTOP_NAME",cursor.getString(cursor.getColumnIndex(LAPTOP_COL3)));
          /*  reg.put("LAPTOP_TYPE",cursor.getString(cursor.getColumnIndex(LAPTOP_COL4)));
            reg.put("LAPTOP_MANUFACTURE",cursor.getString(cursor.getColumnIndex(LAPTOP_COL5)));
            reg.put("LAPTOP_MODEL",cursor.getString(cursor.getColumnIndex(LAPTOP_COL6)));
            reg.put("LAPTOP_WEBPAGE",cursor.getString(cursor.getColumnIndex(LAPTOP_COL7))); */
            regList.add(reg);
        }
        return  regList;
    }
}

