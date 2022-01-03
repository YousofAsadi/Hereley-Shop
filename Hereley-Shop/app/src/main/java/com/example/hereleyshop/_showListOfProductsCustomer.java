package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class _showListOfProductsCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_of_products_customer);

        ListView list = findViewById(R.id.listOfCustomerForDelete);
        String[] resList = new String[_MainActivity.itemsProducts.size()];
        int i = 0;
        for (Product product : _MainActivity.itemsProducts) {
            resList[i] = product.getName() + " --> " + product.getPrice() + " Toman";
            i++;
        }
        ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                resList);
        list.setAdapter(arr);
    }

    ShoppingList currentShoppingList = new ShoppingList(null, null);
    HashMap<Product, Integer> productsInfo = new HashMap<>();
    Integer totalPrice = 0;

    public void addProduct(View v) {
        TextView name = findViewById(R.id.nameOfProductBuy);
        TextView number = findViewById(R.id.numberOfProductBuy);
        Integer integerNumber = Integer.parseInt(number.getText().toString());
        String stringName = name.getText().toString();

        if (findProduct(name.getText().toString()) == null)
            Toast.makeText(this, "ERROR: This Product doesn't exist!", Toast.LENGTH_LONG).show();


        else {
            productsInfo.put(findProduct(stringName), integerNumber);
            totalPrice += integerNumber * findProduct(stringName).getPrice();
            findProduct(stringName).addItsShoppingList(currentShoppingList);

            Toast.makeText(this, "Product added successfully!", Toast.LENGTH_LONG).show();
        }
        name.setText("");
        number.setText("");
    }


    public void finalPurchase(View v) {
        currentShoppingList.changeInfo(productsInfo, totalPrice);
        _MainActivity.currentCustomer.addShoppingList(currentShoppingList);
        _MainActivity.allShoppingLists.add(currentShoppingList);

        Toast.makeText(this, "Purchased successfully!", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, _customerMenu.class);
        startActivity(i);
    }

    public Product findProduct(String name) {
        for (Product product : _MainActivity.itemsProducts) {
            if (name.equals(product.getName())) return product;
        }
        return null;
    }
}