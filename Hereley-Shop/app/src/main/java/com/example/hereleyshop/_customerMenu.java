package com.example.hereleyshop;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class _customerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomer_menu);
    }

    public void goToShop(View v){
        Intent i = new Intent(this, _showListOfProductsCustomer.class);
        startActivity(i);
    }


    public void goToShowInfoCustomer(View v){
        Intent i = new Intent(this, _accountInfoCustomer.class);
        startActivity(i);
    }

    public void goToBuyingHistory(View v){
        Intent i = new Intent(this, _buyingHistory.class);
        startActivity(i);
    }

    public void goToSearchByID(View v){
        Intent i = new Intent(this, _searchByID.class);
        startActivity(i);
    }

    public void logoutCustomer(View v){
        Intent i = new Intent(this, _firstPage.class);
        startActivity(i);
        makeText(getApplicationContext(), "Successfully Signed out!", LENGTH_LONG).show();

    }
}