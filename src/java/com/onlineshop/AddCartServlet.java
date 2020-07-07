
package com.onlineshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet{
    @EJB AddCartBean AddCartBean;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
          HttpSession session = request.getSession();
          
          String itemname = null;
          int customerid = 0;
          int itemid = 0;
          int cartid = 0;
          int quantity = 0;
          double price = 0.0;
          double totalprice = 0.0;
          double newtotalprice = 0.0;
          int newquantity = 0;
          
          String name = request.getSession().getAttribute("username").toString();
          
          
          customerid = AddCartBean.GetCustomerId(name);
          
           if(Integer.parseInt(request.getParameter("qty")) > 0)
           {
               
           
          
          List<Catalogue> productDetails = (List<Catalogue>) session.getAttribute("ItemDetails");
          for(Catalogue catalogue : productDetails)
          {
              itemname = catalogue.getitem();
              itemid = catalogue.getitemid();
              price = catalogue.getppu();
              quantity = Integer.parseInt(request.getParameter("qty"));
              totalprice = catalogue.getppu() * Integer.parseInt(request.getParameter("qty"));
          }
          
          List<Cart> addToCart = (List<Cart>) session.getAttribute("cart");
          
          if(addToCart == null)
          {
              addToCart = new ArrayList<>();
              
              Cart cart = new Cart();
              
              cart.setCustomerid(customerid);
              cart.setItemid(itemid);
              cart.setPrice(price);
              cart.setQuantity(quantity);
              cart.settotalprice(totalprice);
              cart.setitemname(itemname);
              
              
              if(addToCart.add(cart) == true)
              {
                response.sendRedirect(this.getServletContext().getContextPath() + "/cart.jsp");
                session.setAttribute("cart", addToCart);
              }
              else
              {
                  String message = "Your cart could not be inserted.";
                        request.getSession().setAttribute("message", message);
          
                        response.sendRedirect(this.getServletContext().getContextPath() + "/productdetails.jsp");
              }
          }
          else
          {
               Cart cart = new Cart();
              
              cart.setCustomerid(customerid);
              cart.setItemid(itemid);
              cart.setPrice(price);
              cart.setQuantity(quantity);
              cart.settotalprice(totalprice);
              cart.setitemname(itemname);
              
              
              for(int i=0; i<addToCart.size(); i++)
              {
                  if(customerid == addToCart.get(i).getCustomerid() && itemid == addToCart.get(i).getItemid())
                  {
                      cartid = i;
                      
                      newquantity = addToCart.get(cartid).getQuantity() + quantity;
                      newtotalprice = addToCart.get(cartid).getPrice() * newquantity;
                      addToCart.get(cartid).setQuantity(newquantity);
                      addToCart.get(cartid).settotalprice(newtotalprice);
                      
                  }
              }
              if(addToCart.get(cartid).getQuantity() == newquantity )
              {
                response.sendRedirect(this.getServletContext().getContextPath() + "/cart.jsp");
                session.setAttribute("cart", addToCart);
              }
              else if(addToCart.add(cart) == true)
              {
               response.sendRedirect(this.getServletContext().getContextPath() + "/cart.jsp");
               session.setAttribute("cart", addToCart);
              }
               else
                   {
                        String message = "Your cart could not be inserted.";
                        request.getSession().setAttribute("message", message);
          
                        response.sendRedirect(this.getServletContext().getContextPath() + "/productdetails.jsp");
                   }
              
            }
          
           } 
           else
           {
               String message = "You can only select 1 or more.";
                request.getSession().setAttribute("message", message);
          
            response.sendRedirect(this.getServletContext().getContextPath() + "/productdetails.jsp");
           }
    }
  
}
