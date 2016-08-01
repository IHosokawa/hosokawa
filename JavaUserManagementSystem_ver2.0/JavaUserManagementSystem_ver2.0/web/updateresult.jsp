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
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%=udb.getName()%><br>
        生年月日:<%=udb.getYear()%>/<%=udb.getMonth()%>/<%=udb.getDay()%><br>
        種別:<%=jh.exTypenum(udb.getType())%> <br>
        電話番号:<%=udb.getTell()%><br>
        自己紹介:<%=udb.getComment()%><br>
        以上の内容で登録しました。<br>
        <form action="ResultDetail?id=<%=udb.getUserID()%>" method="POST">
            <input type="submit" name="NO" value="詳細画面へ戻る">
        </form>
        <%=jh.home()%>
    </body>
</html>
