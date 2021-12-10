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

@WebServlet(name = "AdPageServlet", urlPatterns = "/ad")
public class ViewAdPageServelet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//        if (req.getSession().getAttribute("user") == null) {
//            res.sendRedirect("/login");
//            return;
//        }


        //grab an ad id from MySQLAdsDao
        Long singleId = Long.parseLong(req.getParameter("ad"));
        try {
            Ad singleAd = DaoFactory.getAdsDao().getAd(singleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            req.setAttribute("ad", DaoFactory.getAdsDao().getAd(singleId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(req, res);
    }
}
