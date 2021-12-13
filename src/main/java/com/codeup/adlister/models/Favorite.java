package com.codeup.adlister.models;

public class Favorite {
    private static long ad_id;
    private long id;
//    private long ad_id;
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

    public Favorite(long ad_id) {
        this.ad_id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static long getAd_id() {
        return ad_id;
    }

    public void setAd_id(long ad_id) {
        this.ad_id = ad_id;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }
}
