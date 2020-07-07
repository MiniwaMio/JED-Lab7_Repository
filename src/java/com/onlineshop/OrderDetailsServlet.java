

package com.onlineshop;

import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/orderdetails")
public class OrderDetailsServlet extends HttpServlet{
     
      @EJB OrderDetailsBean OrderDetailsBean;
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
         HttpSession session = request.getSession();
        
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        
        session.setAttribute("ItemDetails", (Object) OrderDetailsBean.itemDetails(itemId));
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/productdetails.jsp");
        
    }
}
