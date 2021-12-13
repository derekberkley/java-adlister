package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//hello
public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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

    public List<User> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            return createUsersFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all users.", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM user WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    public User findUserById(long id) throws SQLException {
        String query = "SELECT * FROM user WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getBoolean("is_vendor")
            );
        }
        return user;
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO user (first_name, last_name, email, username, password, is_vendor) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getUsername());
            stmt.setString(5, user.getPassword());
            stmt.setBoolean(6, user.getIsVendor());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public void updateProfile(User user) throws SQLException {
        String query = "UPDATE user SET username = ?, email = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getUsername());
        stmt.setLong(3, user.getId());

        stmt.executeUpdate();
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getBoolean("is_vendor")
        );
    }

    private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(extractUser(rs));
        }
        return users;
    }
}