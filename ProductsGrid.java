package com.shaneflaten.projectthreev2;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
// FIXME make update


public class ProductsGrid  extends AppCompatActivity {

    private TableControllerProduct dataBaseUpdate;
    private TableControllerProduct dataBase;
    private static final String TAG = "ProductsGrid";
    private Object Intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        dataBase = new TableControllerProduct(this);
        dataBaseUpdate = new TableControllerProduct(this);



        //Name column one
        String R1C1;
        String R2C1;
        String R3C1;
        String R4C1;
        String R5C1;
        String R6C1;
        String R7C1;

        //Description column 2
        String R1C2;
        String R2C2;
        String R3C2;
        String R4C2;
        String R5C2;
        String R6C2;
        String R7C2;

        //number column three
        String R1C3;
        String R2C3;
        String R3C3;
        String R4C3;
        String R5C3;
        String R6C3;
        String R7C3;

        //DATE column 4
        String R1C4;
        String R2C4;
        String R3C4;
        String R4C4;
        String R5C4;
        String R6C4;
        String R7C4;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_grid);

        //Initiate the new database with the controller and helper
        dataBase = new TableControllerProduct(this);
        Log.d(TAG, "ProductGrid: onCreate Starting");

        //*********************Declare the TextView objects***********
        //:: Name column one
        TextView Row1C1 = (TextView) findViewById(R.id.ItemView1);
        TextView Row2C1 = (TextView) findViewById(R.id.ItemView2);
        TextView Row3C1 = (TextView) findViewById(R.id.ItemView3);
        TextView Row4C1 = (TextView) findViewById(R.id.ItemView4);
        TextView Row5C1 = (TextView) findViewById(R.id.ItemView5);
        TextView Row6C1 = (TextView) findViewById(R.id.ItemView6);
        TextView Row7C1 = (TextView) findViewById(R.id.ItemView7);

        //:: Description column 2
        TextView Row1C2 = (TextView) findViewById(R.id.DescriptionView1);
        TextView Row2C2 = (TextView) findViewById(R.id.DescriptionView2);
        TextView Row3C2 = (TextView) findViewById(R.id.DescriptionView3);
        TextView Row4C2 = (TextView) findViewById(R.id.DescriptionView4);
        TextView Row5C2 = (TextView) findViewById(R.id.DescriptionView5);
        TextView Row6C2 = (TextView) findViewById(R.id.DescriptionView6);
        TextView Row7C2 = (TextView) findViewById(R.id.DescriptionView7);

        //:: Number column three
        TextView Row1C3 = (TextView) findViewById(R.id.NumberView1);
        TextView Row2C3 = (TextView) findViewById(R.id.NumberView2);
        TextView Row3C3 = (TextView) findViewById(R.id.NumberView3);
        TextView Row4C3 = (TextView) findViewById(R.id.NumberView4);
        TextView Row5C3 = (TextView) findViewById(R.id.NumberView5);
        TextView Row6C3 = (TextView) findViewById(R.id.NumberView6);
        TextView Row7C3 = (TextView) findViewById(R.id.NumberView7);

        //:: Date column four
        TextView Row1C4 = (TextView) findViewById(R.id.DateView1);
        TextView Row2C4 = (TextView) findViewById(R.id.DateView2);
        TextView Row3C4 = (TextView) findViewById(R.id.DateView3);
        TextView Row4C4 = (TextView) findViewById(R.id.DateView4);
        TextView Row5C4 = (TextView) findViewById(R.id.DateView5);
        TextView Row6C4 = (TextView) findViewById(R.id.DateView6);
        TextView Row7C4 = (TextView) findViewById(R.id.DateView7);


//  CAll the TableControllerProducts to ReadGrid into an object list
        List<ObjectProduct> products = dataBase.readGrid();

        //Make 4 lists for the columns, num, name, des, date
        ArrayList<String> listName = new ArrayList<String>();
        ArrayList<String> listDes = new ArrayList<String>();
        ArrayList<String> listNum = new ArrayList<String>();
        ArrayList<String> listDate = new ArrayList<String>();

        // Read the object list into 4 string lists
        for (ObjectProduct obj : products) {
            // ::::::::::::::::::::READ RECORDS TO NEW list of STRINGS::::::::::::::::::
            listName.add(obj.productname);
            listDes.add(obj.productdes);
            listNum.add(obj.productnum);
            listDate.add(obj.productdate);

        }
        //Log the lists in the console
        Log.d(TAG, String.valueOf(listName));
        Log.d(TAG, String.valueOf(listDes));
        Log.d(TAG, String.valueOf(listNum));
        Log.d(TAG, String.valueOf(listDate));

        try {
            // Name column
            if (listName.get(0) != null) {
                R1C1 = listName.get(0);
                Row1C1.setText(R1C1);
            }
            if (listName.get(1) != null) {
                R2C1 = listName.get(1);
                Row2C1.setText(R2C1);
            }
            if (listName.get(2) != null) {
                R3C1 = listName.get(2);
                Row3C1.setText(R3C1);
            }
            if (listName.get(3) != null) {
                R4C1 = listName.get(0);
                Row4C1.setText(R4C1);
            }
            if (listName.get(4) != null) {
                R5C1 = listName.get(1);
                Row5C1.setText(R5C1);
            }
            if (listName.get(5) != null) {
                R6C1 = listName.get(2);
                Row6C1.setText(R6C1);
            }
            if (listName.get(6) != null) {
                R7C1 = listName.get(1);
                Row7C1.setText(R7C1);
            }
        } catch (Exception e) {

            Log.d(TAG, String.valueOf(listName));
        }
        try {
            //Description column
            if (listDes.get(0) != null) {
                R1C2 = listDes.get(0);
                Row1C2.setText(R1C2);
            }
            if (listDes.get(1) != null) {
                R2C2 = listDes.get(1);
                Row2C2.setText(R2C2);
            }
            if (listDes.get(2) != null) {
                R3C2 = listDes.get(2);
                Row3C2.setText(R3C2);
            }
            if (listDes.get(3) != null) {
                R4C2 = listDes.get(0);
                Row4C2.setText(R4C2);
            }
            if (listDes.get(4) != null) {
                R5C2 = listDes.get(1);
                Row5C2.setText(R5C2);
            }
            if (listDes.get(5) != null) {
                R6C2 = listDes.get(2);
                Row6C2.setText(R6C2);
            }
            if (listDes.get(6) != null) {
                R7C2 = listDes.get(1);
                Row7C2.setText(R7C2);
            }
        } catch (Exception e) {

            Log.d(TAG, String.valueOf(listDes));
        }
        try {

            // Column Number
            if (listNum.get(0) != null) {
                R1C3 = listNum.get(0);
                Row1C3.setText(R1C3);
            }
            if (listNum.get(1) != null) {
                R2C3 = listNum.get(1);
                Row2C3.setText(R2C3);
            }
            if (listNum.get(2) != null) {
                R3C3 = listNum.get(2);
                Row3C3.setText(R3C3);
            }
            if (listNum.get(3) != null) {
                R4C3 = listNum.get(0);
                Row4C3.setText(R4C3);
            }
            if (listNum.get(4) != null) {
                R5C3 = listNum.get(1);
                Row5C3.setText(R5C3);
            }
            if (listNum.get(5) != null) {
                R6C3 = listNum.get(2);
                Row6C3.setText(R6C3);
            }
            if (listNum.get(6) != null) {
                R7C3 = listNum.get(1);
                Row7C3.setText(R7C3);
            }
        } catch (Exception e) {

            Log.d(TAG, String.valueOf(listNum));
        }
        try {

            //column Date

            if (listDate.get(0) != null) {
                R1C4 = listDate.get(0);
                Row1C4.setText(R1C4);
            }
            if (listDate.get(1) != null) {
                R2C4 = listDate.get(1);
                Row2C4.setText(R2C4);
            }
            if (listDate.get(2) != null) {
                R3C4 = listDate.get(2);
                Row3C4.setText(R3C4);
            }
            if (listDate.get(3) != null) {
                R4C4 = listDate.get(0);
                Row4C4.setText(R4C4);
            }
            if (listDate.get(4) != null) {
                R5C4 = listDate.get(1);
                Row5C4.setText(R5C4);
            }
            if (listDate.get(5) != null) {
                R6C4 = listDate.get(2);
                Row6C4.setText(R6C4);
            }
            if (listDate.get(6) != null) {
                R7C4 = listDate.get(1);
                Row7C4.setText(R7C4);
            }


        } catch (Exception e) {

            Log.d(TAG, String.valueOf(listDate));
        }

        // Create new Data entry for ProductDatabase
        Button buttonCreateProduct = (Button) findViewById(R.id.add_inventory); // identify the button by its ID “buttonCreateStudent
        buttonCreateProduct.setOnClickListener(new OnClickListenerCreateProduct());

        Button buttonUserSMS = (Button) findViewById(R.id.button_SMS);
        buttonUserSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "ProductsGrid: onClick-Clicked to the SMS page");
                Intent intent = new Intent(ProductsGrid.this, SmsActivity.class); // create object to nav to the 3rd screen
                startActivity(intent); // pass the intent object to start activity
            }
        });

        Button buttonRefresh = (Button) findViewById(R.id.button_inventory);
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "ProductsGrid: onClick-Clicked to the refresh page");
                Intent intent = new Intent(ProductsGrid.this, ProductsGrid.class); // create object to nav to the 3rd screen
                startActivity(intent); // pass the intent object to start activity
            }
        });
///FIXME
        // ::::::::::::::::UPDATE BY Pencil ::::::::::::::::::::::



//        ImageButton buttonUpdateProduct1 = (ImageButton) findViewById(R.id.pencilButton1); // identify the button by its ID “buttonCreateStudent
//        buttonUpdateProduct1.setOnClickListener(new UpdateProduct());
//        int productId1 = 1;
//
//
//        final TableControllerProduct tableControllerProduct = new TableControllerProduct(getApplicationContext());
//        ObjectProduct objectProduct = tableControllerProduct.readSingleRecord(productId1);
//
//        ImageButton buttonUpdateProduct2 = (ImageButton) findViewById(R.id.pencilButton2); // identify the button by its ID “buttonCreateStudent
//        buttonUpdateProduct2.setOnClickListener(new UpdateProduct());
//        int productId2 = 2;
//        final TableControllerProduct tableControllerProduct = new TableControllerProduct(getApplicationContext());
//        ObjectProduct objectProduct = tableControllerProduct.readSingleRecord(productId2);
//
//        ImageButton buttonUpdateProduct3 = (ImageButton) findViewById(R.id.pencilButton3); // identify the button by its ID “buttonCreateStudent
//        buttonUpdateProduct3.setOnClickListener(new UpdateProduct());
//        int productId3 = 3;
//        final TableControllerProduct tableControllerProduct = new TableControllerProduct(getApplicationContext());
//        ObjectProduct objectProduct = tableControllerProduct.readSingleRecord(productId3);
//
//        ImageButton buttonUpdateProduct4 = (ImageButton) findViewById(R.id.pencilButton4); // identify the button by its ID “buttonCreateStudent
//        buttonUpdateProduct4.setOnClickListener(new UpdateProduct());
//        int productId4 = 4;
//        final TableControllerProduct tableControllerProduct = new TableControllerProduct(getApplicationContext());
//        ObjectProduct objectProduct = tableControllerProduct.readSingleRecord(productId4);
//
//        ImageButton buttonUpdateProduct5 = (ImageButton) findViewById(R.id.pencilButton5); // identify the button by its ID “buttonCreateStudent
//        buttonUpdateProduct5.setOnClickListener(new UpdateProduct());
//        int productId5 = 5;
//        final TableControllerProduct tableControllerProduct = new TableControllerProduct(getApplicationContext());
//        ObjectProduct objectProduct = tableControllerProduct.readSingleRecord(productId5);
//
//        ImageButton buttonUpdateProduct6 = (ImageButton) findViewById(R.id.pencilButton6); // identify the button by its ID “buttonCreateStudent
//        buttonUpdateProduct6.setOnClickListener(new UpdateProduct());
//        int productId6 = 6;
//        final TableControllerProduct tableControllerProduct = new TableControllerProduct(getApplicationContext());
//        ObjectProduct objectProduct = tableControllerProduct.readSingleRecord(productId6);
//
//        ImageButton buttonUpdateProduct7 = (ImageButton) findViewById(R.id.pencilButton7); // identify the button by its ID “buttonCreateStudent
//        buttonUpdateProduct7.setOnClickListener(new UpdateProduct());
//        int productId7 = 7;
//        final TableControllerProduct tableControllerProduct = new TableControllerProduct(getApplicationContext());
//        ObjectProduct objectProduct = tableControllerProduct.readSingleRecord(productId7);
//
//
//
//


        //buttonUpdateProduct1.setOnClickListener(new View.OnClickListener() {

//            @Override
//            public void onClick(View v) {
//                int i = 1;
//                upDateDialog(i);
//
//            }
//        });

        // ::::::::::::::::DELETE BY GARBAGE CAN ::::::::::::::::::::::


        final boolean[] validate = new boolean[1];




        //row 1
        ImageButton buttonDeleteProduct1 = (ImageButton) findViewById(R.id.garbageButton1);
        buttonDeleteProduct1.setOnClickListener(view -> {
            Log.d(TAG, "ProductsGrid/OnCreate(): button 1 clicked");
            int id;
            id = 1;
            validate[0] = deleteRow(id);
            Intent intent = new Intent(ProductsGrid.this, ProductsGrid.class); // create object to nav to the 3rd screen
            startActivity(intent); // pass the intent object to start activity
        });

        //row 2
        ImageButton buttonDeleteProduct2 = (ImageButton) findViewById(R.id.garbageButton2);
        buttonDeleteProduct2.setOnClickListener(view -> {
            Log.d(TAG, "ProductsGrid/OnCreate(): button 1 clicked");
            int id;
            id = 2;
            validate[0] = deleteRow(id);
            Intent intent = new Intent(ProductsGrid.this, ProductsGrid.class); // create object to nav to the 3rd screen
            startActivity(intent); // pass the intent object to start activity
        });

        //row 3
        ImageButton buttonDeleteProduct3 = (ImageButton) findViewById(R.id.garbageButton3);
        buttonDeleteProduct3.setOnClickListener(view -> {
            Log.d(TAG, "ProductsGrid/OnCreate(): button 1 clicked");
            int id;
            id = 1;
            validate[0] = deleteRow(id);
            Intent intent = new Intent(ProductsGrid.this, ProductsGrid.class); // create object to nav to the 3rd screen
            startActivity(intent); // pass the intent object to start activity
        });

        //row 4
        ImageButton buttonDeleteProduct4 = (ImageButton) findViewById(R.id.garbageButton4);
        buttonDeleteProduct4.setOnClickListener(view -> {
            Log.d(TAG, "ProductsGrid/OnCreate(): button 1 clicked");
            int id;
            id = 1;
            validate[0] = deleteRow(id);
            Intent intent = new Intent(ProductsGrid.this, ProductsGrid.class); // create object to nav to the 3rd screen
            startActivity(intent); // pass the intent object to start activity
        });

        //row 5
        ImageButton buttonDeleteProduct5 = (ImageButton) findViewById(R.id.garbageButton5);
        buttonDeleteProduct5.setOnClickListener(view -> {
            Log.d(TAG, "ProductsGrid/OnCreate(): button 1 clicked");
            int id;
            id = 1;
            validate[0] = deleteRow(id);
            Intent intent = new Intent(ProductsGrid.this, ProductsGrid.class); // create object to nav to the 3rd screen
            startActivity(intent); // pass the intent object to start activity
        });

        //row 6
        ImageButton buttonDeleteProduct6 = (ImageButton) findViewById(R.id.garbageButton6);
        buttonDeleteProduct6.setOnClickListener(view -> {
            Log.d(TAG, "ProductsGrid/OnCreate(): button 1 clicked");
            int id;
            id = 1;
            validate[0] = deleteRow(id);
            Intent intent = new Intent(ProductsGrid.this, ProductsGrid.class); // create object to nav to the 3rd screen
            startActivity(intent); // pass the intent object to start activity
        });

        //row 7
        ImageButton buttonDeleteProduct7 = (ImageButton) findViewById(R.id.garbageButton7);
        buttonDeleteProduct7.setOnClickListener(view -> {
            Log.d(TAG, "ProductsGrid/OnCreate(): button 1 clicked");
            int id;
            id = 1;
            validate[0] = deleteRow(id);
            Intent intent = new Intent(ProductsGrid.this, ProductsGrid.class); // create object to nav to the 3rd screen
            startActivity(intent); // pass the intent object to start activity
        });

        //Delete All
        ImageButton buttonDeleteProduct0 = (ImageButton) findViewById(R.id.garbageButton0);
        buttonDeleteProduct0.setOnClickListener(view -> {
            Log.d(TAG, "ProductsGrid/OnCreate(): button 0 clicked");
            dataBase = new TableControllerProduct(this);
            boolean done = dataBase.deleteAllRecords();
            if (done == true ){
                Log.d(TAG, "ProductsGrid/deleteAllRecords(): all deleted");
            } else {
                Log.d(TAG, "ProductsGrid/deleteAllRecords(): not deleted");
            }
            dataBase.close();
        });

    }

    private void upDateDialog(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Update")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {

                        //dataBaseUpdate.updateContact(i);
                        Toast.makeText(getApplicationContext(), "Updated Successfully",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });



    }





    public boolean deleteRow(int id) {
        dataBase = new TableControllerProduct(this);
        Log.d(TAG, "ProductsGrid/deleteRow(): Starting and the value if id is ____");
        Log.d(TAG, String.valueOf(id));
        Log.d(TAG, "ProductsGrid/deleteRow(): deleteGrid(id) called ");
        boolean done = dataBase.deleteGrid(id);
        dataBase.close();
        return done;
    }
}