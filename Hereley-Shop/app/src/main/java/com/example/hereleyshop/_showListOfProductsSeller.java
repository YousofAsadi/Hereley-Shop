package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class _showListOfProductsSeller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_of_product_seller);

        ListView list = findViewById(R.id.listViewOfProductSeller);
        String[] resList = new String[_MainActivity.itemsProducts.size()];

        if (_MainActivity.itemsProducts.size() == 0)
            Toast.makeText(this, "ERROR: There is no product in shop!", Toast.LENGTH_LONG).show();


        else {
            int i = 0;
            for (Product product: _MainActivity.itemsProducts){
                resList[i] = product.getName() + " / " + product.getPrice() + " Toman / " + "Seller: " + product.getSeller().getMail();
                i++;
            }
            ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                    R.layout.support_simple_spinner_dropdown_item,
                    resList);
            list.setAdapter(arr);
        }
    }
}
