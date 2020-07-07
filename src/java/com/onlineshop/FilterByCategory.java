
package com.onlineshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

@WebServlet("/category")
public class FilterByCategory extends HttpServlet{
    @EJB FilterCategoryBean FilterCategoryBean;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        
        int FilterTerm = Integer.parseInt(request.getParameter("category"));

        session.setAttribute("searchresult", (Object) FilterCategoryBean.filterCatalogue(FilterTerm));
       session.setAttribute("filterterm", (Object) FilterCategoryBean.CatalogueName(FilterTerm));
       
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/searchresults.jsp");
        
    }
}
