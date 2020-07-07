<%@page import="com.onlineshop.Catalogue"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>(EGB) Online Grocery - Search Result</title>
    </head>
    <body>
        <p>
            <b>(EGB)Results</b>
        </p>
        <hr/>
        <p>
            <!--A reminder note to the user on the search term he used-->
            <%
                if(session.getAttribute("searchterm") == null)
                {
                    
                 %>
                    <b>Filtered by <%=session.getAttribute("filterterm")%></b>
                <%    
                }
                else
                {
                    %>  
                Search results for <b> <%=session.getAttribute("searchterm")%> </b>
                <%
                
                session.removeAttribute("searchterm");
                }
                %>
            
        </p>
        <hr/>
        <p>
            <!--Results-->
            <table>
                <tr><th>item</th><th>Price</th></tr>
                <%
                    List<Catalogue> searchResult = (List<Catalogue>) session.getAttribute("searchresult");
                    if(searchResult == null || searchResult.size() <= 0) {
                %>
            <tr><td colspan="2">(No result is found)</td></tr>
                <%
                    } else {
                        for(Catalogue catalogue : searchResult) {
                %>
                <tr>
                    <td><%=catalogue.getitem()%></td>
                    <td><%=catalogue.getppu()%></td>
                    <td>
                        <form action="orderdetails" method="post">
                                    <input type="hidden" name="itemId" value="<%=catalogue.getitemid()%>">
                                    <input type="submit" value="Add Cart">
                                             </form>
                    </td>
                  
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </p>
        <hr/>
        <a href="search.jsp">Return to search page</a><br/>
        <a href="index.html">Go back to home</a>
    </body>
</html>
