<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans"
        import="javax.servlet.http.HttpSession" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("detailData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        ユーザーID:<%= udb.getUserID()%><br>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"/"+udb.getMonth()+"/"+udb.getDay()%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        登録日時:<%= udb.getDate()%><br>
        <form action="Update" method="POST">
            <input type="submit" name="update" value="変更"style="width:100px">
        </form>
        <form action="Delete" method="POST">
            <input type="submit" name="delete" value="削除"style="width:100px">
        </form>
        <form action="SearchResult" method="POST">
            <input type="hidden" name="result" value="RESULT">
            <input type="submit" name="no" value="検索結果へ戻る">
        </form>
    </body>
</html>
