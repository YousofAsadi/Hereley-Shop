package com.example.hereleyshop;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class _signupSeller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_seller);
    }


    public void openLogin(View V) throws NoSuchAlgorithmException {

        TextView email = findViewById(R.id.emailSignupSeller);
        TextView pass = findViewById(R.id.passSignupSeller);
        ArrayList<Product> myProducts = new ArrayList<>();


        boolean Validity = true;
        for (Seller seller : _MainActivity.adminsSeller) {
            if (email.getText().toString().equals(seller.getMail())) {
                makeText(getApplicationContext(), "ERROR: There is an account with this username!", LENGTH_LONG).show();
                Validity = false;
                break;
            }
        }

        if (Validity){
            Seller seller = new Seller(email.getText().toString(), _signup.getHash(pass.getText().toString()), myProducts);

            _MainActivity.adminsSeller.add(seller);

            Intent i = new Intent(this, _firstPage.class);
            startActivity(i);

            Toast.makeText(this, "Your account successfully created!", Toast.LENGTH_LONG).show();
        }
    }
}


