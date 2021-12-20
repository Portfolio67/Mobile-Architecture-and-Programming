package com.shaneflaten.projectthreev2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProduct implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Context context = view.getRootView().getContext(); // inflate an XML layout file.

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //inflate the student_input_form.xml, this will make UI elements or widgets accessible
        final View formElementsView = inflater.inflate(R.layout.product_update_input, null, false);

        final EditText editProductNumber = (EditText) formElementsView.findViewById(R.id.editProductNumber);//List down form widgets inside student_input_form.xml as “final” variables. This is because we will use them inside an AlertDialog.
        final EditText editProductName = (EditText) formElementsView.findViewById(R.id.editProductName);
        final EditText editProductDescription = (EditText) formElementsView.findViewById(R.id.editProductDescription);
        final EditText editProductDate = (EditText) formElementsView.findViewById(R.id.editProductDate);




        DialogInterface dialog;
        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Update Product")
                //.setNegativeButton()
                .setPositiveButton("Update",
                        (dialog1, id) -> {

                            String ProductNumber = editProductNumber.getText().toString();
                            String ProductName = editProductName.getText().toString();
                            String ProductDescription = editProductDescription.getText().toString();
                            String ProductDate= editProductDate.getText().toString();

                            ObjectProduct objectProduct = new ObjectProduct();
                            objectProduct.productnum = ProductNumber;
                            objectProduct.productname = ProductName;
                            objectProduct.productdes = ProductDescription;
                            objectProduct.productdate = ProductDate;

                            editProductNumber.setText(objectProduct.productnum);
                            editProductName.setText(objectProduct.productname);
                            editProductDescription.setText(objectProduct.productdes);
                            editProductDate.setText(objectProduct.productdate);

                            //FIXME
                            boolean UpdateSuccessful = new TableControllerProduct(context).updateProduct(objectProduct);
                            //boolean UpdateSuccessful = new TableControllerProduct.updateProduct(objectProduct);

                            if(UpdateSuccessful){
                                Toast.makeText(context, "Product information was saved.", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(context, "Unable to save Product information.", Toast.LENGTH_LONG).show();
                            }



                            dialog1.cancel();
                        }).show();
//                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // User cancelled the dialog
//                    }
//                });

    }
}
