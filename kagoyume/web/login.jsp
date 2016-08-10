<%-- 
    Document   : login
    Created on : 2016/08/03, 11:20:25
    Author     : You
--%>

<%@page import="javax.servlet.http.HttpServletRequest"
        import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    String beforeUrl = (String)session.getAttribute("BeforeUrl");
%>

<!DOCTYPE html>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if(request.getAttribute("delFlg") != null){ %>削除されたユーザーです<% } %>
        <% if(request.getAttribute("errFlg") != null){ %>入力に誤りがあります<% } %>
        <form action="Login" method="POST">
            ユーザー名:<input type="text" name="txtName" value=""><br>
            パスワード:<input type="text" name="txtPass" value=""><br>
            <input type="submit" value="ログイン"  style="WIDTH: 70px; HEIGHT: 20px">
            <input type="hidden" name="beforeUrl" value="<%=beforeUrl%>">
        </form>
        <br>
        <form action="Registration" method="POST">
            <input type="submit" value="新規登録" style="WIDTH: 70px; HEIGHT: 20px">
            <input type="hidden" name="logac" value="<%=hs.getAttribute("logac")%>">
        </form>
    </body>
</html>
