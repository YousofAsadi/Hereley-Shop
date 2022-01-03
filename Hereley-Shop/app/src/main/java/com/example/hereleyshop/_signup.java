package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class _signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signupSeller(View V){
        Intent i = new Intent(this, _signupSeller.class);
        startActivity(i);
    }
    public void signupCustomer(View V){
        Intent i = new Intent(this, _signupCustomer.class);
        startActivity(i);
    }

    static String getHash(String input) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(input.getBytes());

        byte[] digestedBytes = messageDigest.digest();
        StringBuilder SB = new StringBuilder();
        for (byte b: digestedBytes) {
            SB.append(String.format("%02x", b & 0xff));
        }

        return SB.toString();
    }
}