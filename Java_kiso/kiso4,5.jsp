<%-- 
    Document   : kiso4
    Created on : 2016/06/29, 13:46:36
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int x = 100;
    final int kiso = 10;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>基礎4,5</title>
    </head>
    <body>
        <%
            out.print(x + "+" + kiso + "=" + (x + kiso) + "<br>");
            out.print(x + "-" + kiso + "=" + (x - kiso) + "<br>");
            out.print(x + "*" + kiso + "=" + (x * kiso) + "<br>");
            out.print(x + "/" + kiso + "=" + (x / kiso) + "<br>");
            
            %>
    </body>
</html>
