package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private int Price;

    public Ad(long id, long userId, String title, String description, int price) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        Price = price;
    }

    public Ad(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Ad(long id, String title, String description, int price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.Price = price;
    }

    public Ad(String title, String description, int price) {
        this.title = title;
        this.description = description;
        this.Price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}