package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class _setTheShoppingStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_the_shopping_status);

        // for showing the list of shopping lists
        ListView list = findViewById(R.id.listForSetStatus);
        String[] resList = new String[_MainActivity.allShoppingLists.size()];
        int i = 0;
        if (_MainActivity.allShoppingLists.size() == 0){
            Toast.makeText(this, "ERROR: There is no shopping list!", Toast.LENGTH_LONG).show();
        }
        else{
            for (ShoppingList shoppingList: _MainActivity.allShoppingLists){
                resList[i] = "ID: " + shoppingList.getId() + " -> Status: " + shoppingList.getStatus() + " -> Total Price: " + shoppingList.getTotalPrice();
                i++;
            }
        }
        ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                resList);
        list.setAdapter(arr);
    }

    public void goProcessing(View v){
        Integer ID = Integer.parseInt((((TextView)findViewById(R.id.IDforStatus))).getText().toString()) ;

        boolean isIDValid = false;
        for (ShoppingList shoppinglist: _MainActivity.allShoppingLists) {
            if (ID.equals(shoppinglist.getId())) {
                isIDValid = true;
                shoppinglist.changeStatusTo(ShoppingStatus.Processing);
            }
        }
        if (!isIDValid)
            Toast.makeText(this, "ERROR: Your entered ID is not valid!", Toast.LENGTH_LONG).show();

        updateListOfShoppingList();
    }

    public void goDelivering(View v){
        Integer ID = Integer.parseInt((((TextView)findViewById(R.id.IDforStatus))).getText().toString()) ;

        boolean isIDValid = false;
        for (ShoppingList shoppinglist: _MainActivity.allShoppingLists) {
            if (ID.equals(shoppinglist.getId())) {
                isIDValid = true;
                shoppinglist.changeStatusTo(ShoppingStatus.Delivering);
            }
        }
        if (!isIDValid)
            Toast.makeText(this, "ERROR: Your entered ID in invalid!", Toast.LENGTH_LONG).show();

        updateListOfShoppingList();
    }

    public void goDelivered(View v){
        Integer ID = Integer.parseInt((((TextView)findViewById(R.id.IDforStatus))).getText().toString()) ;

        boolean isIDValid = false;
        for (ShoppingList shoppinglist: _MainActivity.allShoppingLists) {
            if (ID.equals(shoppinglist.getId())) {
                isIDValid = true;
                shoppinglist.changeStatusTo(ShoppingStatus.Delivered);
            }
        }
        if (!isIDValid)
            Toast.makeText(this, "ERROR: Your entered ID in invalid!", Toast.LENGTH_LONG).show();

        updateListOfShoppingList();
    }


    public void updateListOfShoppingList(){
        ListView list = findViewById(R.id.listForSetStatus);
        String[] resList = new String[_MainActivity.allShoppingLists.size()];
        int i = 0;
        if (_MainActivity.allShoppingLists.size() == 0){
            Toast.makeText(this, "There is no shopping list!", Toast.LENGTH_LONG).show();
        }
        else{
            for (ShoppingList shoppingList: _MainActivity.allShoppingLists){
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