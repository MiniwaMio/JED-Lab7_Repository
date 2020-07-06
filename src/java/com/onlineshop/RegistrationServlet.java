/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineshop;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author admin
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
    @EJB
    private RegistrationBean registrationBean;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String email = request.getParameter("email");
        String uname = request.getParameter("username");
        String deliveryAddress = request.getParameter("deliveryAddress");
        String contactNum = request.getParameter("phoneNo");
        String postalCode = request.getParameter("postalCode");
        boolean validation = true;
        
        //validation Process
        validation = registrationBean.isValidEmailAddress(email);
        validation = registrationBean.isValidUName(uname);
        validation = registrationBean.isValidAddress(deliveryAddress);
        validation = registrationBean.isValidContactNumber(contactNum);
        validation = registrationBean.isValidPostalCode(postalCode);
        
        if(validation == false){
            request.getSession().setAttribute("validationErr", "Validation Failed : MSG");
            response.sendRedirect(this.getServletContext().getContextPath()+ "/registration.jsp");
            return;
        }else{
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("username", uname);
            request.getSession().setAttribute("deliveryAdd", deliveryAddress);
            request.getSession().setAttribute("contactNum", contactNum);
            request.getSession().setAttribute("postalCode", postalCode);
        }
        response.sendRedirect(this.getServletContext().getContextPath()+ "/registrationCheck.jsp");
    }
}
