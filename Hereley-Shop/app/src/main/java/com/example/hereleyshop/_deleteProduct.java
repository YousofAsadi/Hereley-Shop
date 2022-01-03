package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class _deleteProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        ListView list = findViewById(R.id.listOfCustomerForDelete);
        String[] resList = new String[_MainActivity.itemsProducts.size()];
        int i = 0;
        for (Product product: _MainActivity.itemsProducts){
            resList[i] = product.getName() + " --> " + product.getPrice() + " Toman";
            i++;
        }
        ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                resList);
        list.setAdapter(arr);
    }

    public void deleteProduct(View v){
        String name = ((TextView)findViewById(R.id.nameOfProductForDelete)).getText().toString();
        if (findThisProduct(name) == null)
            Toast.makeText(this, "ERROR: This Product doesn't exist!", Toast.LENGTH_LONG).show();

        else{
            _MainActivity.itemsProducts.remove(findThisProduct(name));
            Toast.makeText(this, "The Product successfully deleted!", Toast.LENGTH_LONG).show();
        }


        ListView list = findViewById(R.id.listOfCustomerForDelete);
        String[] resList = new String[_MainActivity.itemsProducts.size()];
        int i = 0;
        for (Product product: _MainActivity.itemsProducts){
            resList[i] = product.getName() + " --> " + product.getPrice() + " Toman";
            i++;
        }
        ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                resList);
        list.setAdapter(arr);
}

    public Product findThisProduct(String name){
        for (Product product: _MainActivity.itemsProducts) {
            if (name.equals(product.getName())) return product;
        }
        return null;
    }
}