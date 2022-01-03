package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class _buyingHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying_history);

        ListView list = findViewById(R.id.listOfCustomerForDelete);
        String[] resList = new String[_MainActivity.currentCustomer.getBuyDetails().size()];
        int i = 0;
        if (_MainActivity.currentCustomer.getBuyDetails().size() == 0){
            Toast.makeText(this, "ERROR: Nothing to Show!", Toast.LENGTH_LONG).show();
        }
        else{
            for (ShoppingList shoppingList: _MainActivity.currentCustomer.getBuyDetails()){
                resList[i] = "ID: " + shoppingList.getId() + " -> Status: " + shoppingList.getStatus() + " -> Total Price: " + shoppingList.getTotalPrice();
                i++;
            }
        }
        ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                resList);
        list.setAdapter(arr);
    }
}

