package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Favorite;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLFavsDao implements Favorites{
    private Connection connection;

    public MySQLFavsDao(Config config) {
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
    public List<Favorite> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM favorite");
            return createFavoritesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all users.", e);
        }
    }

    @Override
    public Long insert(Favorite favorite) {
        try {
            String insertQuery = "INSERT INTO favorite(ad_id) VALUES (?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, Favorite.getAd_id());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding a new Favorite.", e);
        }
    }

    @Override
    public Favorite getFavorite(long favorite) throws SQLException {
        String adQuery = "SELECT * FROM favorite WHERE id = ? LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(adQuery);
        statement.setLong(1, favorite);
        ResultSet rs = statement.executeQuery();

        if ((! rs.next())) {
            return null;
        }
        return extractFavorite(rs);
    }

    @Override
    public List<Ad> searchFavorites(String search) throws SQLException {
        return null;
    }

    private List<Favorite> createFavoritesFromResults(ResultSet rs) throws SQLException {
        List<Favorite> favs = new ArrayList<>();
        while (rs.next()) {
            favs.add(extractFavorite(rs));
        }
        return favs;
    }

    private Favorite extractFavorite(ResultSet rs) throws SQLException {
        return new Favorite(
                rs.getLong("id"),
                rs.getLong("ad_id")
        );
    }
}