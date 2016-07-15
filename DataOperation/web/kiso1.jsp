<%-- 
    Document   : kiso1
    Created on : 2016/07/13, 12:04:46
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./kiso2.jsp" method="post">
            名前:<input type="text" name="txtName">
            <p>
            性別:<input type="radio" name="radioSeibetu" value="男">男
            <input type="radio" name="radioSeibetu" value="女">女
            </p>
            趣味:<textarea name="txtSyumi"></textarea>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
