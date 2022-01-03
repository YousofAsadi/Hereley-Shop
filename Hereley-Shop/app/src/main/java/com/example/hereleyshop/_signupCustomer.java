package com.example.hereleyshop;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class _signupCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_customer);
    }


    public void signupCustomerChecker(View V) throws NoSuchAlgorithmException {

        TextView email = findViewById(R.id.emailSignupCustomer);
        TextView pass = findViewById(R.id.passSignupCustomer);
        ArrayList<ShoppingList> buyDetails = new ArrayList<>();

        boolean Validity = true;
        for (Customer customer : _MainActivity.adminsCustomer) {
            if (email.getText().toString().equals(customer.getMail())) {
                makeText(getApplicationContext(), "ERROR: There is an account with this username!", LENGTH_LONG).show();
                Validity = false;
                break;
            }
        }

        if (Validity) {
            Customer cus = new Customer(email.getText().toString(), _signup.getHash(pass.getText().toString()), buyDetails);

            _MainActivity.adminsCustomer.add(cus);

            makeText(getApplicationContext(), "Your account successfully created!", LENGTH_LONG).show();

            Intent i = new Intent(this, _firstPage.class);
            startActivity(i);
        }
    }
}