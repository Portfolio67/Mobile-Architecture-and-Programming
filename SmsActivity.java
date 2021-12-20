package com.shaneflaten.projectthreev2;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;


import androidx.core.app.ActivityCompat;

import java.util.List;

public class SmsActivity  extends AppCompatActivity {
    private TableControllerProduct dataBase;
    private static final String TAG = "";


    EditText userNumber, userMessage;
    Button btnSend, buttonSetAlert;
    SharedPreferences permissionStatus;
    private boolean sentToSettings = false;
    private static final int SMS_PERMISSION_CONSTANT = 100;
    private static final int REQUEST_PERMISSION_SETTING = 101;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "SMS: onCreate Starting");
        setContentView(R.layout.activity_sms);

        dataBase = new TableControllerProduct(this);

        userMessage = (EditText) findViewById(R.id.editText1);
        userNumber = (EditText) findViewById(R.id.editText2);
        buttonSetAlert = (Button) findViewById(R.id.buttonSetAlert);
        btnSend = (Button) findViewById(R.id.ButtonSendSms);
        Log.d(TAG, "SMS: got view Ids");

        permissionStatus = getSharedPreferences("permissionStatus", MODE_PRIVATE);



        Button buttonUserSMS = (Button)findViewById(R.id.button_inventory_from_sms);
        buttonUserSMS.setOnClickListener(view -> {
            Log.d(TAG, "onClick : Clicked to the ProductsGrid page");
            Intent intent = new Intent(SmsActivity.this, ProductsGrid.class); // create object to nav to the 3rd screen
            startActivity(intent); // pass the intent object to start activity
        });


        Button buttonUserSMSBack = (Button)findViewById(R.id.button_SMS);
        buttonUserSMSBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "ProductsGrid: onClick-Clicked to the SMS page");
                Intent intent = new Intent(SmsActivity.this, SmsActivity.class); // create object to nav to the 3rd screen
                startActivity(intent); // pass the intent object to start activity
            }
        });

        btnSend.setOnClickListener(view -> SendMessage(userNumber.getText().toString(), userMessage.getText().toString()));
        Log.d(TAG, "SMS:----------------------- send button clicked");
        Log.d(TAG, "SMS: ----------------------- User message is: ");
        Log.d(TAG, String.valueOf(userMessage)); // string
        Log.d(TAG, "SMS: ----------------------- User number is: ");
        Log.d(TAG, String.valueOf(userNumber)); // string

        if (ActivityCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "SMS: ----------------------- send got permission");
            if (ActivityCompat.shouldShowRequestPermissionRationale(SmsActivity.this, Manifest.permission.SEND_SMS)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SmsActivity.this);
                builder.setTitle("Need SMS Permission");
                builder.setMessage("This app needs your permission to send SMS Messages.");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "SMS: ----------------------- builder dialog cancel clicked");
                        dialog.cancel();
                        ActivityCompat.requestPermissions(SmsActivity.this,
                                new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                builder.show();
            } else if (permissionStatus.getBoolean(Manifest.permission.SEND_SMS, false)) {
                Log.d(TAG, "SMS: ----------------------- denied permission at first, because of new user,  NOW SET the permission");
                AlertDialog.Builder builder = new AlertDialog.Builder(SmsActivity.this);
                builder.setTitle("SMS Permission");
                builder.setPositiveButton("Grant", (dialog, which) -> {
                    dialog.cancel();
                    sentToSettings = true;


                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);


                    startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                    Toast.makeText(getBaseContext(),
                            "Go to Permissions ", Toast.LENGTH_SHORT).show();
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            } else {
                ActivityCompat.requestPermissions(SmsActivity.this, new String[]{Manifest.permission.SEND_SMS}
                        , SMS_PERMISSION_CONSTANT);
            }

            SharedPreferences.Editor editor = permissionStatus.edit();
            editor.putBoolean(Manifest.permission.SEND_SMS, true);
            editor.commit();

        }
        buttonSetAlert.setOnClickListener(view -> SendDelayedMessage(userNumber.getText().toString(), "inventory low"));
        Log.d(TAG, "SMS: ----------------------- SET ALERT button clicked");
        Log.d(TAG, "SMS: ----------------------- User number is: ");
        Log.d(TAG, String.valueOf(userNumber)); // string

        Log.d(TAG, "----------------------- set alert clicked");
        if (ActivityCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(SmsActivity.this, Manifest.permission.SEND_SMS)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SmsActivity.this);
                builder.setTitle("Need Alert Permission");
                builder.setMessage("This app needs SMS permission to send Alerts.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(SmsActivity.this,
                                new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                builder.show();
            } else if (permissionStatus.getBoolean(Manifest.permission.SEND_SMS, false)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SmsActivity.this);


                builder.setTitle("SMS Permission");
                builder.setPositiveButton("Grant", (dialog, which) -> {
                    dialog.cancel();
                    sentToSettings = true;


                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);


                    startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                    Toast.makeText(getBaseContext(),
                            "Visit Permissions ", Toast.LENGTH_SHORT).show();
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            } else {
                ActivityCompat.requestPermissions(SmsActivity.this, new String[]{Manifest.permission.SEND_SMS}
                        , SMS_PERMISSION_CONSTANT);
            }

            SharedPreferences.Editor editor = permissionStatus.edit();
            editor.putBoolean(Manifest.permission.SEND_SMS, true);
            editor.commit();

        }
    }

    public void SendMessage(String strMobileNo, String strMessage) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(strMobileNo, null, strMessage, null, null);
            Toast.makeText(getApplicationContext(), "Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
        }


    }

    public void SendDelayedMessage(String strMobileNo, String strMessage) {
        List<ObjectProduct> products = dataBase.readGrid();

        if (strMessage == "inventory low") {
            for (ObjectProduct obj : products) {
                String productNum = obj.productnum;
                if(productNum == null || productNum.equals("1") || productNum.equals("1") || productNum.equals("2") || productNum.equals("3")){
                    Log.d(TAG, "SmsActivity：-------------------------- productNum is null");
                    Toast toast = Toast.makeText(this, "About to send SMS low alert", Toast.LENGTH_LONG);
                    toast.show();
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(strMobileNo, null, strMessage, null, null);
                        Toast.makeText(getApplicationContext(), "Sent",
                                Toast.LENGTH_LONG).show();
                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(), ex.getMessage().toString(),
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
}
