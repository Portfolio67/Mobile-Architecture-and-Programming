package com.shaneflaten.projectthreev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TableControllerUser dataBase;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Main onCreate Starting");
        dataBase = new TableControllerUser(this);

        Button buttonCreateStudent = (Button) findViewById(R.id.buttonCreateUser); // identify the button by its ID “buttonCreateStudent
        buttonCreateStudent.setOnClickListener(new OnClickListenerCreateUser());

        // User input login information
        final EditText editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);//List down form widgets inside student_input_form.xml as “final” variables. This is because we will use them inside an AlertDialog.
        final EditText editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        //text watchers
        editTextTextEmailAddress.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                editTextTextEmailAddress.getText();

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }
        });
        editTextTextPassword.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {

                editTextTextPassword.getText();
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }
        });


        final boolean[] validate = new boolean[1];

        Button buttonUserLogin = (Button) findViewById(R.id.buttonLoginUser);
        buttonUserLogin.setOnClickListener(view -> {

            String LoginUserId = editTextTextEmailAddress.getText().toString();
            Log.d(TAG, LoginUserId);

            String LoginUserPass = editTextTextPassword.getText().toString();
            Log.d(TAG, LoginUserPass);

            validate[0] = readRecords(LoginUserId, LoginUserPass);
            if (validate[0] == true) {
                Log.d(TAG, "Main: Passed validation in readRecords now onClick->Clicked to the Grid");
                Intent intent = new Intent(MainActivity.this, ProductsGrid.class); // create object to nav to the second screen
                startActivity(intent); // pass the intent object to start activity
            }
        });

    }


    public boolean readRecords(String LoginUserId,String LoginUserPass) {
        Log.d(TAG, "Main: readRecords() Starting for validation");
        List<ObjectUser> users = dataBase.read();

        Log.d(TAG, "Main: Reading the ObjectList called users Should not be empty they are in object format:");
        Log.d(TAG, String.valueOf(users)); // string


        for (ObjectUser obj : users) {
            String userId = obj.userid;
            String userPass = obj.pass;

            //Log.d(TAG, "Main: For each object list Reading the value of  each userId and pass they are:");
            Log.d(TAG, String.valueOf(userId)); // string
            Log.d(TAG, String.valueOf(userPass)); // string

            if(userId == null){
                Log.d(TAG, "Main： user id null");
                Toast toast = Toast.makeText(this, "User is not created yet", Toast.LENGTH_LONG);
                toast.show();
            }
            if(userPass == null){
                Log.d(TAG, "Main: user id ");
                Toast toast = Toast.makeText(this, "User is not created yet", Toast.LENGTH_LONG);
                toast.show();
            }
            if(userId.equals(LoginUserId) & userPass.equals(LoginUserPass)){
                Log.d(TAG, "Main: user id is a MATCH with the input");
                Log.d(TAG, "Main: user Pass is a MATCH");
                Toast toast = Toast.makeText(this, "ALL PASSED", Toast.LENGTH_LONG);
                toast.show();
                return true;
            } else {
                Log.d(TAG, "Main: user id  and pass failed to match ");
            }
        }
        return false;
    }
}
