package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class _accountInfoSeller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info_seller);
    }

    public void showInfoSeller(View v){
        ((TextView)findViewById(R.id.emailSeller)).setText(_MainActivity.currentSeller.getMail());
        ((TextView)findViewById(R.id.passwordSeller)).setText(_MainActivity.currentSeller.getPass());
    }
}