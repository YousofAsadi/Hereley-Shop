package com.example.hereleyshop;

public class User {
    private String email;
    private String password;

    public User(String email, String password){
        setInfo(email, password);
    }

    void setInfo(String email, String password){
        this.email = email;
        this.password = password;
    }

    String getMail(){ return this.email; }
    String getPass(){ return this.password; }


}
