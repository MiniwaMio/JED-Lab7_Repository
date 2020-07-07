
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="search" method="post">
            <p>
                Please enter the name of an item <br/>
                <input type="text" name="searchterm" required/><br/>
                <input type="submit" value="Search"/>
            </p>
        </form>
        <p>Filter items by</p>
        <table border="1">
            <th>
                 <form action="allitem" method="post">
                    <input type="submit" value="All">
                </form>
            </th>
            
            <th>
                <form action="category" method="post">
                <input type="hidden" name="category" value="1">
                <input type="submit" value="Vegetables">
        </form>
            </th>
            
            <th>
                 <form action="category" method="post">
                 <input type="hidden" name="category" value="2">
                 <input type="submit" value="Meat">
                </form>
            </th>
       
            <th>
                <form action="category" method="post">
                <input type="hidden" name="category" value="3">
                <input type="submit" value="Dairy">
                </form>
            </th>
      
            <th>
                <form action="category" method="post">
                <input type="hidden" name="category" value="4">
                <input type="submit" value="Bakery">
                </form>
            </th>
        
        </table>
        
    </body>
</html>
