package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditProfileServlet", urlPatterns = "/edit-profile")
public class EditProfileServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            res.sendRedirect("/login");
            return;
        }

        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("username", user.getUsername());
        req.setAttribute("email", user.getEmail());

        req.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws  IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = (User) req.getSession().getAttribute("user");

        user.setUsername((username));
        user.setEmail(email);
        user.setPassword(password);

        try {
            DaoFactory.getUsersDao().updateProfile(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.sendRedirect("/profile");
    }
}
