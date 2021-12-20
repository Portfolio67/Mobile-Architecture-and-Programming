package com.shaneflaten.projectthreev2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDataBaseHandeler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "UserDatabase";
    private static final String TAG = "";

    public UserDataBaseHandeler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  //The super keyword in java is a reference variable that is used to refer parent class objects.  The keyword “super” came into the picture with the concept of Inheritance.
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE users " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userid TEXT, " +
                "pass TEXT ) ";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS users";
        db.execSQL(sql);

        onCreate(db);
    }
}