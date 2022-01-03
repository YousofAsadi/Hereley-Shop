package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Map;

public class _searchByID extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_id);
    }

    public void checkID(View v) {
        Integer ID = Integer.parseInt(((TextView) findViewById(R.id.id1)).getText().toString());

        boolean isItValidID = false;
        for (ShoppingList shoppingList : _MainActivity.currentCustomer.getBuyDetails()) {
            if (ID.equals(shoppingList.getId())) {
                isItValidID = true;

                ListView list1 = findViewById(R.id.listview5);
                String[] resList1 = {"ID: " + shoppingList.getId()
                        , "Status: " + shoppingList.getStatus()
                        , "Total Price: " + shoppingList.getTotalPrice()};

                ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                        R.layout.support_simple_spinner_dropdown_item,
                        resList1);
                list1.setAdapter(arr);


                ListView list2 = findViewById(R.id.listview6);
                String[] resList2 = new String[shoppingList.getProducts().size()];

                int i = 0;
                for (Map.Entry product : shoppingList.getProducts().entrySet()) {
                    resList2[i] = findProductName(product.getKey()) + " -> " + product.getValue();
                    i++;
                }
                arr = new ArrayAdapter<>(this,
                        R.layout.support_simple_spinner_dropdown_item,
                        resList2);
                list2.setAdapter(arr);
            }
        }
        if (!isItValidID)
            Toast.makeText(this, "ERROR: Your entered ID is not valid!", Toast.LENGTH_LONG).show();
    }

    public String findProductName(Object product){
        for (Product tempProduct: _MainActivity.itemsProducts) {
            if (product == tempProduct) return tempProduct.getName();
        }
        return null;
    }
}