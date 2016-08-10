<%-- 
    Document   : buycomplete
    Created on : 2016/08/03, 11:23:40
    Author     : You
--%>
<%@page import="kagoyume.KagoyumeHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入完了ページ</title>
    </head>
    <body>
        購入が完了しました。
        <%=kh.home()%>
    </body>
</html>
