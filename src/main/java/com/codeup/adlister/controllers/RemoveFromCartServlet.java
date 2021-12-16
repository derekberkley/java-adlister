package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RemoveFromCartServlet", urlPatterns = "/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = (String) request.getSession().getAttribute("url");
        List<Ad> currentCart = (List<Ad>) request.getSession().getAttribute("cart");
        long singleId = Long.parseLong(request.getParameter("ad"));
        try {
            Ad ad = DaoFactory.getAdsDao().getAd(singleId);
            currentCart.removeIf(ad1 -> ad.getId() == ad1.getId()); //what is happening here
            request.getSession().setAttribute("cart", currentCart);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(currentCart);
        response.sendRedirect("/cart");
    }
}