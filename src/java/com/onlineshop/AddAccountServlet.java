package com.onlineshop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
@WebServlet("/addAccount")
public class AddAccountServlet extends HttpServlet
{
    @EJB
    private RegistrationBean registrationBean;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String email = request.getSession().getAttribute("email").toString();
        String username = request.getSession().getAttribute("username").toString();
        String deliveryAdd = request.getSession().getAttribute("deliveryAdd").toString();
        String contactNum = request.getSession().getAttribute("contactNum").toString();
        String postalCode = request.getSession().getAttribute("postalCode").toString();
        
        int uid = registrationBean.addAccount(username, deliveryAdd, postalCode, contactNum, email);
        request.getSession().setAttribute("customerId", uid);
        response.sendRedirect(this.getServletContext().getContextPath()+ "/index.html");
        
    }
}
