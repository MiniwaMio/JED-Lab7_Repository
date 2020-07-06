<%-- 
    Document   : index
    Created on : Jul 6, 2020, 9:55:26 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Registration Page</title>
    </head>
    <body>
        <h1>Please confirm your details</h1>
        <form method="post" action="addAccount">
            <label>Name: <%=session.getAttribute("username").toString()%></label><br>
            <label>Email: <%=session.getAttribute("email").toString()%></label><br>
            <label>Postal Code : <%=session.getAttribute("postalCode").toString()%></label><br>
            <label>Contact Number: <%=session.getAttribute("contactNum").toString()%></label><br>
            <label>Deliery Address: <%=session.getAttribute("deliveryAdd").toString()%></label><br>
            <input type="submit" value="Confirm Registration"><br>
            <a href="registration.jsp">Wrong input, go back</a>
        </form>
    </body>
</html>
