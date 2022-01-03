package com.example.hereleyshop;

import java.util.HashMap;

public class ShoppingList {
    private Integer id;
    private ShoppingStatus status;
    private HashMap<Product, Integer> products;
    private Integer totalPrice;

    public ShoppingList(HashMap<Product, Integer> products, Integer totalPrice){
        setInfo(products, totalPrice);
    }

    public void setInfo(HashMap<Product, Integer> products, Integer totalPrice) {
        _MainActivity.idHelper++;
        this.id = _MainActivity.idHelper;

        this.status = ShoppingStatus.Processing;

        this.products = products;

        this.totalPrice = totalPrice;
    }

    public void changeInfo(HashMap<Product, Integer> products, Integer totalPrice){
        this.products = products;

        this.totalPrice = totalPrice;
    }

    void changeStatusTo(ShoppingStatus shoppingStatus){ this.status = shoppingStatus;}

    Integer getId(){
        return this.id;
    }

    ShoppingStatus getStatus(){
        return this.status;
    }

    HashMap<Product, Integer> getProducts() {
        return this.products;
    }

    Integer getTotalPrice(){
        return this.totalPrice;
    }
}