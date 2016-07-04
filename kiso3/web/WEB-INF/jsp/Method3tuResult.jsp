<%-- 
    Document   : Method3tuResult
    Created on : 2016/07/04, 15:31:54
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.kiso3_3.ResultMethod3tu"%>

<!DOCTYPE html>
<html>
    <head>
        <%
            ResultMethod3tu data = (ResultMethod3tu)request.getAttribute("Data");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data != null){
                out.println(data.getD());
            }
        %>
        
        <h1>Hello World!</h1>
    </body>
</html>
