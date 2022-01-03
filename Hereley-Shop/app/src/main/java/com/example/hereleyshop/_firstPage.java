package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class _firstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
    }

    public void openLogin(View v){
        Intent i = new Intent(this, _login.class);
        startActivity(i);
    }

    public void openSignup(View v){
        Intent i = new Intent(this, _signup.class);
        startActivity(i);
    }



}