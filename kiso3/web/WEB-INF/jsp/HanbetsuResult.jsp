<%-- 
    Document   : HanbetsuResult
    Created on : 2016/07/04, 14:34:58
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.kiso3_2.ResultHanbetsu"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultHanbetsu data = (ResultHanbetsu)request.getAttribute("Data");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data != null){
                out.println("入力されている数字は " + data.getHikisuu() + " です。");
            }
        %>
        <h1>Hello World!</h1>
    </body>
</html>
