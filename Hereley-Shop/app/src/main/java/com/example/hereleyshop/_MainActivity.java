package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;



public class _MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static Integer idHelper = 100;
    public static ArrayList<ShoppingList> allShoppingLists = new ArrayList<>();
    public static ArrayList<Product> itemsProducts = new ArrayList<>();
    public static ArrayList<Customer> adminsCustomer = new ArrayList<>();
    public static ArrayList<Seller> adminsSeller = new ArrayList<>();
    public static Customer currentCustomer = new Customer(null, null, null);
    public static Seller currentSeller = new Seller(null, null, null);


    public void goToFirstPage(View v){
        Intent i = new Intent(this, _firstPage.class);
        startActivity(i);
    }
}