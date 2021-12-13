package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findUserById(long id) throws SQLException;
    Long insert(User user);
    void updateProfile(User user) throws SQLException;
}
