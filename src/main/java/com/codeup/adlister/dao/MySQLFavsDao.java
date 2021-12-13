package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Favorite;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public Long insert(Favorite favorite) {
        return null;
    }

    @Override
    public Ad getFavorite(long favorite) throws SQLException {
        return null;
    }

    @Override
    public List<Ad> searchFavorites(String search) throws SQLException {
        return null;
    }
}