package com.shaneflaten.projectthreev2;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ProductDataBaseHandeler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "ProductDatabase";
    private static final String TAG = "";

    public ProductDataBaseHandeler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  //The super keyword in java is a reference variable that is used to refer parent class objects.  The keyword “super” came into the picture with the concept of Inheritance.
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE products " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "productnum TEXT, " +
                "productname TEXT," +
                "productdes TEXT, " +
                "productdate TEXT) ";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS products";
        db.execSQL(sql);

        onCreate(db);
    }

    //::::::::EXAMPLE OF UPDATING THE DATE BY CHOOSING A PRODUCT NAME IN A COLUMN:::::::::::
    String name = "Dog";
    String date = "12/19/2021";
    public boolean update(String name, String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE "+DATABASE_NAME+" SET productdate = "+"'"+date+"' "+ "WHERE productname = "+"'"+name+"'");
        return true;
    }

//    //FIXME THIS is An Example of an update
//    UPDATE table_name
//    SET column1 = value1, column2 = value2...., columnN = valueN
//    WHERE [condition];
}