<%-- 
    Document   : kiso2-1
    Created on : 2016/06/29, 17:21:46
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>基礎2-1</title>
    </head>
    <body>
        <%
        int a = 1;
        switch(a){
            case 1:
                out.print("one");
                break;
            case 2:
                out.print("two");
                break;
            default:
                out.print("想定外");
        }
        %>
    </body>
</html>
