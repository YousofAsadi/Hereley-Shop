package com.example.hereleyshop;

import java.util.ArrayList;

public class Product {
    private String name;
    private Integer price;
    private final Seller seller;
    private final ArrayList<ShoppingList> itsShoppingLists;

    public void addItsShoppingList(ShoppingList shoppingList){
        this.itsShoppingLists.add(shoppingList);
    }


    public Product(String name, Integer price, Seller seller, ArrayList<ShoppingList> itsShoppingLists){
        this.seller = seller;
        this.itsShoppingLists = itsShoppingLists;
        setInfo(name, price);
    }

    void setInfo(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    String getName() { return this.name; }

    Integer getPrice() { return this.price; }

    Seller getSeller() { return this.seller; }

}
