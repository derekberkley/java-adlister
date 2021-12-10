package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {

            stmt = connection.prepareStatement("SELECT * FROM ad");
            ResultSet rs = stmt.executeQuery();

            stmt = connection.prepareStatement("SELECT * FROM ad");
            ResultSet resultSet = stmt.executeQuery();

            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ad(title, description, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(3, ad.getPrice());
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Ad getAd(long ad) throws SQLException {
        String adQuery = "SELECT * FROM ad WHERE id = ? LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(adQuery);
        statement.setLong(1, ad);
        ResultSet rs = statement.executeQuery();

        if ((! rs.next())) {
            return null;
        }
        return extractAd(rs);

    }

    @Override
    public List<Ad> searchAds(String search) throws SQLException {
        List<Ad> adList = new ArrayList<>();
        String searchQuery = "SELECT * FROM ad WHERE title LIKE ?";
        String searchTerm = "%" + search + "%";

        PreparedStatement statement = connection.prepareStatement(searchQuery, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, searchTerm);
        statement.executeQuery();

        ResultSet rs = statement.getResultSet();


        return createAdsFromResults(rs);

    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("ven_id"),
            rs.getString("title"),
            rs.getString("description"),
                rs.getInt("price")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }


}


