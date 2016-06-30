<%-- 
    Document   : kiso2-4
    Created on : 2016/06/29, 17:47:41
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
            String a = " ";
            for(int i = 0; i < 30; i++){
                a = a + "A";
            }
            out.print(a);
        %>
    </body>
</html>
