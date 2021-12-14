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
import java.util.List;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Ad> currentCart = (List<Ad>) request.getSession().getAttribute("cart");
//        try {
//            Ad adToAdd = DaoFactory.getAdsDao().getAd(singleId);
//            currentCart.add(adToAdd);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        User user = (User) request.getSession().getAttribute("user");
        request.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = (String) request.getSession().getAttribute("url");
        List<Ad> currentCart = (List<Ad>) request.getSession().getAttribute("cart");
        long singleId = Long.parseLong(request.getParameter("ad"));
        Ad ad = null;
        try {
            ad = DaoFactory.getAdsDao().getAd(singleId);
            currentCart.add(ad);
            request.getSession().setAttribute("cart", currentCart);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(url);
    }
}