<%-- 
    Document   : kiso4
    Created on : 2016/07/13, 14:23:00
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Date time = new Date();
            HttpSession hs = request.getSession(true);
            hs.setAttribute("LastAccess",time.toString());
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession hss = request.getSession(true);
            out.println("前回のアクセス " + hss.getAttribute("LastAccess"));
        %>
    </body>
</html>
