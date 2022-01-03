package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class _customersInfoForSellers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_info_for_sellers);

        ListView list = findViewById(R.id.listViewCustomersInfo);
        String[] resList = new String[_MainActivity.adminsCustomer.size()];
        int i = 0;
        if (_MainActivity.adminsCustomer.size() == 0)
            Toast.makeText(this, "ERROR: There is no Customer!", Toast.LENGTH_LONG).show();

        else {
            for (Customer customer: _MainActivity.adminsCustomer){
                resList[i] = "User: " + customer.getMail() + " | Pass: " + customer.getPass();
                i++;
            }
            ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                    R.layout.support_simple_spinner_dropdown_item,
                    resList);
            list.setAdapter(arr);
        }
    }
}
