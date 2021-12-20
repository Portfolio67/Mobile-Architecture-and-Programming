package com.shaneflaten.projectthreev2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OnClickListenerCreateProduct implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Context context = view.getRootView().getContext(); // inflate an XML layout file.

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //inflate the student_input_form.xml, this will make UI elements or widgets accessible
        final View formElementsView = inflater.inflate(R.layout.product_input_form, null, false);

        final EditText editTextProductNumber = (EditText) formElementsView.findViewById(R.id.editTextProductNumber);//List down form widgets inside student_input_form.xml as “final” variables. This is because we will use them inside an AlertDialog.
        final EditText editTextProductName = (EditText) formElementsView.findViewById(R.id.editTextProductName);
        final EditText editTextProductDescription = (EditText) formElementsView.findViewById(R.id.editTextProductDescription);
        final EditText editTextProductDate = (EditText) formElementsView.findViewById(R.id.editTextProductDate);


        DialogInterface dialog;
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Create Product")
                .setPositiveButton("Add",
                        (dialog1, id) -> {

                            String ProductNumber = editTextProductNumber.getText().toString();
                            String ProductName = editTextProductName.getText().toString();
                            String ProductDescription = editTextProductDescription.getText().toString();
                            String ProductDate= editTextProductDate.getText().toString();

                            ObjectProduct objectProduct = new ObjectProduct();
                            objectProduct.productnum = ProductNumber;
                            objectProduct.productname = ProductName;
                            objectProduct.productdes = ProductDescription;
                            objectProduct.productdate = ProductDate;

                            boolean createSuccessful = new TableControllerProduct(context).create(objectProduct);

                            if(createSuccessful){
                                Toast.makeText(context, "Product information was saved.", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(context, "Unable to save Product information.", Toast.LENGTH_LONG).show();
                            }



                            dialog1.cancel();
                        }).show();

    }
}
