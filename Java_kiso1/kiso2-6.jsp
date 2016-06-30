<%-- 
    Document   : kiso2-6
    Created on : 2016/06/29, 17:55:37
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int a = 1000;
            while(100 <= a){
                a = a / 2;
                out.print(a + "<br>");
            }
        %>
    </body>
</html>
