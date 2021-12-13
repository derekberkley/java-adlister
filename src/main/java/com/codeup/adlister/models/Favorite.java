package com.codeup.adlister.models;

public class Favorite {
    private long id;
    private long ad_id;
    private long cust_id;

    public Favorite(long id, long ad_id, long cust_id) {
        this.id = id;
        this.ad_id = ad_id;
        this.cust_id = cust_id;
    }

    public Favorite(long id, long ad_id){
        this.id = id;
        this.ad_id = ad_id;
    }
}
