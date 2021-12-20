package com.shaneflaten.projectthreev2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class TableControllerProduct extends ProductDataBaseHandeler {

    private static final String TAG = "";

    public TableControllerProduct(Context context) {
        super(context);
    }

    public boolean create(ObjectProduct objectProduct) {
        Log.d(TAG, "TableControllerProduct/create(): Starting");

        ContentValues values = new ContentValues();
        values.put("productnum", objectProduct.productnum);
        values.put("productname", objectProduct.productname);
        values.put("productdes", objectProduct.productdes);
        values.put("productdate", objectProduct.productdate);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("products", null, values) > 0;
        db.close();

        return createSuccessful;

    }

    public boolean deleteGrid (int id) {
        Log.d(TAG, "TableControllerProduct/deleteGrid(): called");
        Log.d(TAG, String.valueOf(id)); // string
        SQLiteDatabase db = this.getWritableDatabase();
        boolean deleted = db.delete("products", "id =" + id, null) > 0;
        Log.d(TAG, "TableControllerProduct/deleteGrid(): deleted ");
        Log.d(TAG, String.valueOf(deleted)); // string
        System.err.println(deleted);
        db.close();
        return deleted;
    }

        // deletes all records
    public boolean deleteAllRecords(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from  products ");
        db.close();
        return true;
    }

    public List<ObjectProduct> readGrid() {

        Log.d(TAG, "TableControllerProduct/readGrid(): Starting");
        List<ObjectProduct> recordsList = new ArrayList<>();

        String sql = "SELECT * FROM products ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            Log.d(TAG, "TableControllerProduct/readGrid(): move to first Starting");
            do {
                @SuppressLint("Range") int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                @SuppressLint("Range") String productNum = cursor.getString(cursor.getColumnIndex("productnum"));
                @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex("productname"));
                @SuppressLint("Range") String productDes = cursor.getString(cursor.getColumnIndex("productdes"));
                @SuppressLint("Range") String productDate = cursor.getString(cursor.getColumnIndex("productdate"));

                ObjectProduct objectProduct = new ObjectProduct();
                objectProduct.id = id;
                objectProduct.productnum = productNum;
                objectProduct.productname = productName;
                objectProduct.productdes = productDes;
                objectProduct.productdate = productDate;

                recordsList.add(objectProduct);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        Log.d(TAG, "TableControllerProduct/readGrid: sending list");

        return recordsList;
    }



    public boolean updateContact(int id, ObjectProduct objectProduct) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("productnum", objectProduct.productnum);
        contentValues.put("productname", objectProduct.productname);
        contentValues.put("productdes", objectProduct.productdes);
        contentValues.put("productdate", objectProduct.productdate);
        db.update("contacts", contentValues, "id = id ", new String[] { Integer.toString(id) } );
        db.close();
        return true;
    }

    public ObjectProduct readSingleRecord(int productId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ObjectProduct objectProduct = null;

        String sql = "SELECT * FROM students WHERE id = " + productId;
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String productnum = cursor.getString(cursor.getColumnIndex("productnum"));
            String productname = cursor.getString(cursor.getColumnIndex("productname"));
            String productdes = cursor.getString(cursor.getColumnIndex("productdes"));
            String productdate = cursor.getString(cursor.getColumnIndex("productdate"));

            objectProduct = new ObjectProduct();
            objectProduct.id = id;
            objectProduct.productnum = productnum;
            objectProduct.productname = productname;
            objectProduct.productdes = productdes;
            objectProduct.productdate = productdate;


        }
        cursor.close();
        db.close();
        return objectProduct;
    }

    public boolean updateProduct(ObjectProduct objectproduct) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("productnum", objectproduct.productnum);
        contentValues.put("productname", objectproduct.productname);
        contentValues.put("productdes", objectproduct.productdes);
        contentValues.put("productdate", objectproduct.productdate);

        String where = "id = ?";

        String[] whereArgs = { Integer.toString(objectproduct.id) };

        SQLiteDatabase db = this.getWritableDatabase();
        boolean updated = db.update("students", contentValues, where, whereArgs) > 0;
        db.close();
        return updated;

    }



    public List<ObjectProduct> readGridColumnNumber() {

        Log.d(TAG, "TableControllerProduct/readGrid(): Starting");
        List<ObjectProduct> recordsList = new ArrayList<>();

        String sql = "SELECT * FROM products ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            Log.d(TAG, "TableControllerProduct/readGrid(): move to first Starting");
            do {
                @SuppressLint("Range") int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                @SuppressLint("Range") String productNum = cursor.getString(cursor.getColumnIndex("productnum"));
                @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex("productname"));
                @SuppressLint("Range") String productDes = cursor.getString(cursor.getColumnIndex("productdes"));
                @SuppressLint("Range") String productDate = cursor.getString(cursor.getColumnIndex("productdate"));

                ObjectProduct objectProduct = new ObjectProduct();
                objectProduct.id = id;
                objectProduct.productnum = productNum;
                objectProduct.productname = productName;
                objectProduct.productdes = productDes;
                objectProduct.productdate = productDate;

                recordsList.add(objectProduct);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

}




