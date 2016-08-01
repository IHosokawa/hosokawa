<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    boolean check = false;
    if(session.getAttribute("detailData") == null){
        check = true;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
        <h1>削除確認</h1>
        <%if(check == true){%>
        削除しました。<br>
        <%}else{%>
        削除できませんでした。<br>
        <%}%>
        <form action="SearchResult" method="POST">
            <input type="hidden" name="result" value="RESULT">
            <input type="submit" name="no" value="検索結果へ戻る">
        </form>
        <%=jh.home()%>
    </body>
</html>
