package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static java.lang.Integer.parseInt;

@WebServlet(name= "DeleteServlet", urlPatterns = "/delete/*")
public class DeleteServlet extends HttpServlet {

//

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().getAttribute(“user”) == null {
//        response.sendRedirect(“/ad”);
//        return;
//    }
    String adId = request.getPathInfo().substring(1);
        DaoFactory.getAdsDao().Delete(parseInt(adId));
}
        }

