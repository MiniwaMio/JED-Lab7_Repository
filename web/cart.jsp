<%@page import="com.onlineshop.Cart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Grocery</title>
    </head>
    <body>
        <h1>EJB - Online Grocery</h1>
     
      
                <table border="1">
                    
                    <tr>
                        <td>Item</td><td>Total Costs</td><td>Quantity</td>
                    </tr>
                    <%
                    List<Cart> CartDetails = (List<Cart>) session.getAttribute("cart");
           
                     double cartprice = 0.0;
                      
                     
                        
                    for(Cart cart : CartDetails) { 
                       
                         cartprice += cart.gettotalprice();
                       
                %>
                    <tr>
                                
                        <td><%=cart.getitemname() %></td>
                        <td><%=cart.gettotalprice()%></td>
                        <td><%=cart.getQuantity()%></td>
                  
                      
                    
                    </tr>
                         <%
                        
                    }
                    %>
                </table>
                 
                        <p>Total Price: $<%=cartprice%></p>
                 
              
                        
       
        <form action="confirmcheckout" method="post">
            <input type="submit" value="Checkout">
        </form>
        <br>
        <br>
         <p>
            Back to <a href="search.jsp">Shopping</a> <br>
            Back to <a href="home.jsp">Home</a> 
           
        </p>
        
    </body>
</html>
