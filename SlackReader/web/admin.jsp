<%-- 
    Document   : admin
    Created on : 2016/08/16, 15:59:38
    Author     : You
--%>
<%@page import="java.util.ArrayList"
        import="srvlt.RegistData"
        import="srvlt.UserDataDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UserDataDTO al = (UserDataDTO)session.getAttribute("RegistData");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>管理画面</title>
    </head>
    <body>
        <%/* for(int i = 0; i < al.size(); i++){ */%>
        <form action="Delete" method="POST">
            URL<a href="<%=al.getRegistData().get(0)%>">サイト名</a>
            <input type="submit" value="削除">
        </form>
        <%  %>
        <form action="Regist" method="POST">
            URL<input type="text" name="registUrl" placeholder="ここに登録したいサイトのRSSURLを入力してください">
            <input type="submit" value="登録">
        </form>
        <%%>
    </body>
</html>
