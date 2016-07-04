<%-- 
    Document   : FortuneTellingResult
    Created on : 2016/07/04, 12:45:33
    Author     : You
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "org.mypackage.sample.ResultData"%>    
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultData result = (ResultData)request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (result != null){
                out.println("あなたの" + result.getD() + "の運勢は" + result.getLuck() + "です。");
            }
        %>
        
        <h1>Hello World!</h1>
    </body>
</html>
