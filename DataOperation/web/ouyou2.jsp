<%-- 
    Document   : ouyou2
    Created on : 2016/07/13, 15:15:07
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession hs = request.getSession(true);
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("txtName");
    String sei  = request.getParameter("radioSei");
    String syumi= request.getParameter("mulText");
    hs.setAttribute("Name", name);
    hs.setAttribute("Sei",sei);
    hs.setAttribute("Syumi", syumi);
%>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.println(name + "<br>");
            out.println(sei + "<br>");
        %>
    </body>
</html>
