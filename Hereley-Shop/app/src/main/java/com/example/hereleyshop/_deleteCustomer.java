package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class _deleteCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_customer);

        ListView list = findViewById(R.id.listOfCustomerForDelete);
        String[] resList = new String[_MainActivity.adminsCustomer.size()];
        int i = 0;
        for (Customer customer: _MainActivity.adminsCustomer){
            resList[i] = "User: " + customer.getMail() + " | Pass: " + customer.getPass();
            i++;
        }
        ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                resList);
        list.setAdapter(arr);
    }

    public void deleteCustomer(View v){
        String user = ((TextView)findViewById(R.id.nameOfCustomerForDelete)).getText().toString();
        if (findThisCustomer(user) == null)
            Toast.makeText(this, "ERROR: This Customer doesn't exist!", Toast.LENGTH_LONG).show();

        else{
            _MainActivity.adminsCustomer.remove(findThisCustomer(user));
            Toast.makeText(this, "The Customer successfully deleted!", Toast.LENGTH_LONG).show();
        }


        ListView list = findViewById(R.id.listOfCustomerForDelete);
        String[] resList = new String[_MainActivity.adminsCustomer.size()];
        int i = 0;
        for (Customer customer: _MainActivity.adminsCustomer){
            resList[i] = "User: " + customer.getMail() + " | Pass: " + customer.getPass();
            i++;
        }
        ArrayAdapter<String> arr = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                resList);
        list.setAdapter(arr);
    }

    public Customer findThisCustomer(String user){
        for (Customer customer: _MainActivity.adminsCustomer) {
            if (user.equals(customer.getMail())) return customer;
        }
        return null;
    }
}