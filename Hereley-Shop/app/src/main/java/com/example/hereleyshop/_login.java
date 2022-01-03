package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class _login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginSeller(View v){
        Intent i = new Intent(this, _loginSeller.class);
        startActivity(i);
    }
    public void loginCustomer(View v){
        Intent i = new Intent(this, _loginCustomer.class);
        startActivity(i);
    }
}