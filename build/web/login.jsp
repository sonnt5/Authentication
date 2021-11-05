<%-- 
    Document   : login
    Created on : Jun 9, 2021, 2:48:12 PM
    Author     : Sap-lap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="login">
            User: <input type="text" name="user"/><br/>
            Pass: <input type="password" name="pass" /><br/>
            <input type="checkbox" name="rem" value="rem" /> Remember Me. <br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
