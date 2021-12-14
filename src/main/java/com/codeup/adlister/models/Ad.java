package com.codeup.adlister.models;

public class Ad {
    private  long id;
    private long userId;
    private String title;
    private  String description;
    private  int price;
//    private String category;

    public Ad(long id, long userId, String title, String description, int price) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
//        this.category = category;
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
        this.price = price;
    }

    public Ad(String title, String description, int price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }


//    public Ad(long id, long ven_id, String title, String description, int price) {
//        this.id = id;
//        this.ven_id = ven_id;
//    }

//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }

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
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}