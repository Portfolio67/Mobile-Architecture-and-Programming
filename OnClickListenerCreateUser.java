package com.shaneflaten.projectthreev2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OnClickListenerCreateUser implements View.OnClickListener {
    private static final String TAG = "" ;

    @Override
    public void onClick(View view) {
        Context context = view.getRootView().getContext(); // inflate an XML layout file.

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //inflate the student_input_form.xml, this will make UI elements or widgets accessible
        final View formElementsView = inflater.inflate(R.layout.user_input_form, null, false);
        Log.d(TAG, "onClickListner Starting");

        final EditText editTextUserId = (EditText) formElementsView.findViewById(R.id.editTextUserId);//List down form widgets inside student_input_form.xml as “final” variables. This is because we will use them inside an AlertDialog.
        final EditText editTextUserPass = (EditText) formElementsView.findViewById(R.id.editTextUserPass);
        Log.d(TAG, "onClickListner  dialog ");
        DialogInterface dialog;
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Create User")
                //.setNegativeButton("cancel", )
                .setPositiveButton("Add",
                        (dialog1, id) -> {
                            ObjectUser objectUser = new ObjectUser();

                            String UserId = editTextUserId.getText().toString();
                            Log.d(TAG, UserId); // string

                            String UserPass = editTextUserPass.getText().toString();
                            Log.d(TAG, UserPass); // string

                            Log.d(TAG, "OnClickListner:  Setting the object with stings");
                            objectUser.userid = UserId;
                            objectUser.pass = UserPass;

                            boolean yes = new TableControllerUser(context).create(objectUser);

                            if(yes){
                                Toast.makeText(context, "User information was saved.", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(context, "Unable to save User information.", Toast.LENGTH_LONG).show();
                            }

                            dialog1.cancel();
                        }).show();
    }
}
