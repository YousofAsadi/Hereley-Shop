package com.example.hereleyshop;

import java.util.ArrayList;

public class Customer extends User {
    private final ArrayList<ShoppingList> buyDetails;

    public Customer(String email, String password, ArrayList<ShoppingList> buyDetails) {
        super(email, password);
        this.buyDetails = buyDetails;
    }

    ArrayList<ShoppingList> getBuyDetails(){ return this.buyDetails; }

    public void addShoppingList(ShoppingList shoppingList){
        this.buyDetails.add(shoppingList);
    }
}

