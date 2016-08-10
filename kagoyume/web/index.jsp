<%-- 
    Document   : index
    Created on : 2016/08/03, 11:16:43
    Author     : You
--%>
<%@page import="kagoyume.KagoyumeHelper" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    //ログイン状態を初期化 li:ログアウト ll:ログイン
    if(session.getAttribute("Login") == null){
        session.setAttribute("Login", "li");
    }
    String login = (String) session.getAttribute("Login");
    //以下使うか未定
    boolean reinput = false;
    if(request.getAttribute("reinput") != null &&
            request.getAttribute("reinput").equals("REINPUT")){
        reinput = true;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>トップページ</title>
    </head>
    <body>
        <%=kh.login(login)%><br>
        システムの説明<br>
        <form action="Search" method="GET">
            <input type="text" name="keyword" value="<%if(reinput == true){out.println(request.getAttribute("keyward"));}%>"><br>
            <input type="submit" value="検索">
        </form>
    </body>
</html>