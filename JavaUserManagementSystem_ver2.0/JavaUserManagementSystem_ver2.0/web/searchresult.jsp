<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans"
        import="java.util.ArrayList"
        import="java.util.Date"
        import="java.text.SimpleDateFormat"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList al = (ArrayList)session.getAttribute("resultData");
    UserDataBeans udb = null;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%if(al.size() != 0){
                for(int i = 0;i < al.size();i++){
                    udb = (UserDataBeans)al.get(i);%>
                    <tr>
                        <td><a href="ResultDetail?id=<%= udb.getUserID()%>"><%= udb.getName()%></a></td>
                        <td><%= udb.getYear()%></td>
                        <td><%= jh.exTypenum(udb.getType())%></td>
                        <td><%= udb.getDate()%></td>
                    </tr>
            <%}}else{%>
                データが存在しません。
            <%}%>
        </table>
    </body>
    <%=jh.home()%>
</html>
