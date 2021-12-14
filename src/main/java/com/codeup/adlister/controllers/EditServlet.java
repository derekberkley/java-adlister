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

import static java.lang.Integer.parseInt;

@WebServlet(name="edit", urlPatterns = "/edit/*")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getPathInfo().substring(1);
        request.setAttribute("id",Long.parseLong(id));
        try {
            Ad ad = DaoFactory.getAdsDao().getAd(Long.parseLong(id));
            request.setAttribute("ad", ad);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int id = parseInt(request.getParameter("id"));
        Ad ad = new Ad(id,
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                parseInt(request.getParameter("price")));
        try {
            DaoFactory.getAdsDao().Edit(ad);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
