package com.example.hereleyshop;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class _sellerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_menu);
    }

    public void goToAddProduct(View v){
        Intent i = new Intent(this, _addProduct.class);
        startActivity(i);

    }

    public void logoutSeller(View v){
        Intent i = new Intent(this, _firstPage.class);
        startActivity(i);
        makeText(getApplicationContext(), "Successfully Signed out!", LENGTH_LONG).show();
    }

    public void goToShowInfoSeller(View v){
        Intent i = new Intent(this, _accountInfoSeller.class);
        startActivity(i);
    }

    public void goToShowCustomersInfo(View v){
        Intent i = new Intent(this, _customersInfoForSellers.class);
        startActivity(i);
    }

    public void goToShowListOfProduct(View v){
        Intent i = new Intent(this, _showListOfProductsSeller.class);
        startActivity(i);
    }

    public void goToDeleteProduct(View v){
        Intent i = new Intent(this, _deleteProduct.class);
        startActivity(i);
    }

    public void goToDeleteCustomer(View v){
        Intent i = new Intent(this, _deleteCustomer.class);
        startActivity(i);
    }

    public void goToSetStatus(View v){
        Intent i = new Intent(this, _setTheShoppingStatus.class);
        startActivity(i);
    }

}