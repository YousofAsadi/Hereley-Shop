package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class _accountInfoCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info_customer);
    }

    public void showInfoCustomer(View v){
        ((TextView)findViewById(R.id.email)).setText(_MainActivity.currentCustomer.getMail());
        ((TextView)findViewById(R.id.password)).setText(_MainActivity.currentCustomer.getPass());
    }
}