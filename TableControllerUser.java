package com.shaneflaten.projectthreev2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TableControllerUser extends UserDataBaseHandeler {

    private static final String TAG = "";

    public TableControllerUser(Context context ) {
        super(context);
    }

    public boolean create(ObjectUser objectUser) {

        ContentValues values = new ContentValues();
        values.put("userid", objectUser.userid);
        values.put("pass", objectUser.pass);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("users", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public List<ObjectUser> read() {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d(TAG, "Table controller read() Starting");
        List<ObjectUser> recordsList = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY id DESC";

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            Log.d(TAG, "Table controller move to first Starting");
            do {
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String userId = cursor.getString(cursor.getColumnIndex("userid"));
                String userPass = cursor.getString(cursor.getColumnIndex("pass"));

                ObjectUser objectUser = new ObjectUser();
                objectUser.id = id;
                objectUser.userid = userId;
                objectUser.pass = userPass;

                recordsList.add(objectUser);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

}
