package com.example.hereleyshop;

import java.util.ArrayList;

public class Seller extends User {
    public Seller(String email, String password, ArrayList<Product> myProducts) {
        super(email, password);
        this.myProducts = myProducts;
    }

    private final ArrayList<Product> myProducts;

    public ArrayList<Product> getMyProducts(){return this.myProducts;}
    public void addProduct(Product product){
        this.myProducts.add(product);
    }
}
