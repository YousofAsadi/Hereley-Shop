package com.example.hereleyshop;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class _addProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
    }

    public void addProduct(View v){

        String name = ((TextView)findViewById(R.id.nameProductAdd)).getText().toString();
        Integer price = Integer.parseInt(((TextView)findViewById(R.id.priceProductAdd)).getText().toString());

        ArrayList<ShoppingList> primeArray= new ArrayList<>();

        Product product = new Product(name, price, _MainActivity.currentSeller, primeArray);

        _MainActivity.itemsProducts.add(product);

        _MainActivity.currentSeller.addProduct(product);

        makeText(getApplicationContext(), "Your Product Added Successfully!", LENGTH_LONG).show();

        Intent i = new Intent(this, _sellerMenu.class);
        startActivity(i);
    }
}