package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private byte isVendor;

    public User(long id, String username, String email, String password) {}

    public User(String username, String email, String password, String firstName, String lastName, byte isVendor) {
        this.username = username;
        this.email = email;
        setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVendor = isVendor;
    }

    public User(long id, String username, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVendor = 0;
    }

    public User(long id, String username, String email, String password, String firstName, String lastName, byte isVendor) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVendor = isVendor;
    }

    public User(long userId, long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getIsVendor(){
        return this.isVendor;
    }

    public void setIsVendor(byte isVendor) {
        this.isVendor = isVendor;
    }
}