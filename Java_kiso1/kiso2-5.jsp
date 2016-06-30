<%-- 
    Document   : kiso2-5
    Created on : 2016/06/29, 17:51:34
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
            int a = 0;
            for(int i = 0; i <= 100; i++){
                a = a + i;
            }
            out.print(a);
        %>
    </body>
</html>
