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

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String search = req.getParameter("search");

        List<Ad> adList = null;
        try {
            adList = DaoFactory.getAdsDao().searchAds(search);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(adList);
        req.getSession().setAttribute("search", adList);
        res.sendRedirect("/ads/search");

    }
}
