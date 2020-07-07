
package com.onlineshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{
    @EJB SearchBean SearchBean;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        
        String searchTerm = request.getParameter("searchterm");
        
        session.setAttribute("searchresult", (Object) SearchBean.searchCatalogue(searchTerm) );
        session.setAttribute("searchterm", searchTerm);
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/searchresults.jsp");
        
    }
}
