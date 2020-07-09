<%-- 
    Document   : card
    Created on : Jul 7, 2020, 12:06:18 AM
    Author     : Norelle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Card Validation</title>
    </head>
    <body>
        <h1>Please Enter Your Card Information</h1>
        <form method="post" action="confirmCheckout">
            <p>
                Credit Card Number: <input type="text" name="creditcard" /><br/>
                <font color="red">
                    <%=session.getAttribute("cardmessage")==null?"":session.getAttribute("cardmessage")%><br/>
                </font>
                <input type="submit" value="Confirm Checkout"/>
            </p>    
        </form>
        <%
            //Clear the message at the end of the JSP
            session.setAttribute("cardmessage",null);
        %>
    </body>
</html>
