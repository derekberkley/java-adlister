package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "ViewFavoritesServlet", urlPatterns = "/fav")
public class ViewFavoritesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user != null) {
            Long singleId = Long.parseLong(request.getParameter("ad"));
            try {
                Ad singleAd = DaoFactory.getAdsDao().getAd(singleId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                request.setAttribute("ad", DaoFactory.getAdsDao().getAd(singleId));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/WEB-INF/favorites.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}