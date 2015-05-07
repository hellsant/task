<%-- 
    Document   : login
    Created on : Apr 19, 2015, 9:01:59 PM
    Author     : douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="connection" method="post">
                <h2> user </h2>
                <p><input type="text" name="user" id="user"/></p>
                <h2> password </h2>
                <input type="password" name="userPass" id="userPass"/>
                <input type="submit" name="ok" id="ok" value="ok"/>
            </form>
            <%
            System.out.println("");
            %>
        </div>
    </body>
</html>
