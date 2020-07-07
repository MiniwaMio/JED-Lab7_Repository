/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Norelle
 */
@WebServlet("/confirmCheckout")
public class CheckOutServlet extends HttpServlet {

    @EJB
    private CheckOutBean checkoutBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Change naming convention for session Attributes
        HttpSession session = request.getSession();
        int customerid = Integer.parseInt(session.getAttribute("customerId").toString());

        String cardNumber = request.getParameter("creditcard");
        String message;

        if (checkoutBean.validateCard(cardNumber).equals("success")) {
            System.out.println("Card is ok");
            message = "Order is Successful";
            //Create New Order and insert (LOOP)
            List<Cart> cartOrders = (List<Cart>) session.getAttribute("cart");

            for (Cart cart : cartOrders) {
                int itemid = cart.getItemid();
                int quantity = cart.getQuantity();
                session.setAttribute("error", itemid);
                
                checkoutBean.createOrder(customerid, itemid, quantity);
            }

            session.setAttribute("cardmessage", message);
            response.sendRedirect(this.getServletContext().getContextPath() + "/success.jsp");

        } else {
            System.out.println("Card is cannot work");
            message = "Credit Card Number is invalid";
            session.setAttribute("cardmessage", message);
           RequestDispatcher rd = request.getRequestDispatcher("/card.jsp");
            rd.forward(request, response);
        }

    }
}
