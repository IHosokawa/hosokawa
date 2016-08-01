<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("detailData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    このレコードを本当に削除しますか？<br>
    ユーザーID:<%= udb.getUserID()%><br>
    名前:<%= udb.getName()%><br>
    生年月日:<%=udb.getYear()%>/<%=udb.getMonth()%>/<%=udb.getDay()%><br>
    種別:<%= jh.exTypenum(udb.getType())%><br>
    電話番号:<%= udb.getTell()%><br>
    自己紹介:<%= udb.getComment()%><br>
    登録日時:<%= udb.getDate()%><br>
    <form action="http://localhost:8080/JavaUserManagementSystem_ver2.0/DeleteResult" method="POST">
        <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
        <input type="submit" name="YES" value="はい"style="width:100px">
    </form><br>
    <form action="http://localhost:8080/JavaUserManagementSystem_ver2.0/ResultDetail?id=<%= udb.getUserID()%>" method="POST">
        <input type="submit" name="NO" value="いいえ"style="width:100px">
    </form>
    </body>
</html>
