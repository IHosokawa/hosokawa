<%-- 
    Document   : UserData2Result
    Created on : 2016/07/05, 11:20:24
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.kiso3_5_6.ResultUserData2"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultUserData2 data = (ResultUserData2)request.getAttribute("Data");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data.getIndex()[0] != null){
                for(String val : data.getIndex()){
                    out.println(val);
                }
            }else{
                out.println("そのIDのユーザーは存在しません。");
            }
        %>
        <h1>Hello World!</h1>
    </body>
</html>
