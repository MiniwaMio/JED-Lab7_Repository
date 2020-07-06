<%-- 
    Document   : registration
    Created on : Jul 6, 2020, 9:55:11 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>bad registration page</title>
    </head>
    <body>
        <h1>This is a online grocery registration page</h1>
        <form method="post" action="registration">
            Username : <input type="text" name="username" required><br>
            Email : <input type="email" name="email" required><br>
            Contact Number : <input type="text" name="phoneNo" required><br>
            Delivery Address : <input type="text" name="deliveryAddress" required><br>
            Postal Code : <input type="text" name="postalCode" required><br>
            <input type="submit" value="register">
        </form>
    </body>
</html>
