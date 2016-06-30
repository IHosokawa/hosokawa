<%-- 
    Document   : kiso2-9
    Created on : 2016/06/30, 13:21:08
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HashMap<String, Integer> G = new HashMap<String, Integer>();
            G.put("STR", 80);
            G.put("LUK", 120);
            G.put("DEX", 100);
            G.put("INT", 33);
            G.put("MND", 20);
            for(Map.Entry<String,Integer> b : G.entrySet()){
                out.print(b.getKey() + " に ");
                out.print(b.getValue() + "<br>");
            }
        %>
    </body>
</html>
