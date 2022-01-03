package com.example.hereleyshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

public class _loginCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_customer);
    }

    public void loginCustomerChecker(View v) throws NoSuchAlgorithmException {
        boolean isItACustomer = false;

        TextView email = findViewById(R.id.emailLoginSeller);
        TextView pass = findViewById(R.id.passwordLoginSeller);

        for (Customer customer : _MainActivity.adminsCustomer) {
            if ((email.getText().toString()).equals(customer.getMail()) && (_signup.getHash(pass.getText().toString())).equals(customer.getPass())) {
                isItACustomer = true;

                _MainActivity.currentCustomer = new Customer(customer.getMail(), customer.getPass(), customer.getBuyDetails());

                Toast.makeText(this, "Welcome to your account!", Toast.LENGTH_LONG).show();

                Intent i = new Intent(this, _customerMenu.class);
                startActivity(i);

                break;
            }
        }

        if (!isItACustomer) {
            Toast.makeText(this, "ERROR: Your email or password is wrong!", Toast.LENGTH_LONG).show();
        }
    }
}

