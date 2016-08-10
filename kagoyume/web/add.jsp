<%-- 
    Document   : add
    Created on : 2016/08/03, 11:19:48
    Author     : You
--%>
<%@page import="kagoyume.SearchData"
        import="kagoyume.KagoyumeHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    String login = (String)session.getAttribute("Login");
    SearchData sdSd = (SearchData)session.getAttribute("SearchData");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=kh.login(login)%><br>
        カートに追加しました
        <form action="Search" method="GET">
            <input type="submit" value="検索画面へ戻る">
            <input type="hidden" name="keyword" value="<%=sdSd.getSearchName()%>">
        </form>
        <form action="Cart" method="POST">
            <input type="submit" value="カートの内容を確認">
        </form>
    </body>
</html>
