package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

public class _loginSeller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_seller);

    }
    public void loginSellerChecker(View v) throws NoSuchAlgorithmException {
        boolean isItASeller = false;

        TextView email = findViewById(R.id.emailLoginSeller);
        TextView pass = findViewById(R.id.passwordLoginSeller);

        for (Seller seller : _MainActivity.adminsSeller) {
            if ((email.getText().toString()).equals(seller.getMail()) && (_signup.getHash(pass.getText().toString())).equals(seller.getPass())) {
                isItASeller = true;

                _MainActivity.currentSeller = new Seller(seller.getMail(), seller.getPass(), seller.getMyProducts());

                Toast.makeText(this, "Welcome to your account!", Toast.LENGTH_LONG).show();

                Intent i = new Intent(this, _sellerMenu.class);
                startActivity(i);

                break;
            }
        }

        if (!isItASeller) {
            Toast.makeText(this, "ERROR: Your email or password is wrong!", Toast.LENGTH_LONG).show();
        }
    }
}
