<%@page import="com.onlineshop.Catalogue"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Quantity!</title>
    </head>
    <body>
          <%
                    List<Catalogue> itemdetail = (List<Catalogue>) session.getAttribute("ItemDetails");
                    for(Catalogue catalogue : itemdetail) { 
                %>
              
        
                <table border="1">
                    <tr>
                        <td>Item</td>
                        <td>Price</td>
                      
                    </tr>
                    <tr>
                                <td><%=catalogue.getitem()%></td>
                               <td><%=catalogue.getppu()%></td>
 
                    </tr>
                    
                </table>
                        <%
                        }
                %>
                <br>
                  <font color="red">
                 <%=session.getAttribute("message")==null?"":session.getAttribute("message")%><br/>
            </font>
        <form action="addcart" method="post">
            Select Quantity
            <input type="number" name="qty" required>
            
            <input type="submit" value="Add to Cart">
            
        </form>
      
        <br>
        
        Return to <a href="search.jsp">Search</a> <br>
        Return to <a href="home.jsp">Home</a>
        
        
        <%
            //Clear the message at the end of the JSP
            session.setAttribute("message",null);
        %>
    </body>
</html>
