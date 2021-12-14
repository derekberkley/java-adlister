package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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
            String insertQuery = "INSERT INTO ad(user_id, title, description, price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setLong(4, ad.getPrice());

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

            rs.getLong("user_id"),
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

    public List<Ad> getFeaturedAds() {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ad");
            ResultSet rs = stmt.executeQuery();

            List<Ad> allAds = createAdsFromResults(rs);
            Collections.shuffle(allAds);
            return allAds.subList(0, 4);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
   }

    @Override
    public Long Delete(int id) {
        try {
            String insertQuery = "DELETE FROM ad WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad.", e);
        }
    }



    public List<Ad> adsById(Long id) throws SQLException {
        String query = "SELECT * FROM ad WHERE user_id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        return createAdsFromResults(rs);
    }

    @Override
    public void Edit(Ad ad) {
        try {
            String query = "UPDATE ad SET title = ?, description = ?, price = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            statement.setLong(3, ad.getPrice());
            statement.setLong(4, ad.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Error running", e);
        }
    }
}