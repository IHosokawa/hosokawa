<%-- 
    Document   : kiso2-3
    Created on : 2016/06/29, 17:34:21
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
        long a = 8;
        for(int i = 0; i < 20; i++){
            a = a * 8;
            out.print((i+1) + ":" + a + "<br>");
        }
        out.print(a);
        %>
    </body>
</html>
