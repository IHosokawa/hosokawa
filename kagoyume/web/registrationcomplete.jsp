<%-- 
    Document   : registrationcomplete
    Created on : 2016/08/03, 11:21:49
    Author     : You
--%>
<%@page import="kagoyume.UserData"
        import="kagoyume.KagoyumeHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    UserData ud = (UserData)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(ud != null){%>
            <div Align="center">
                ユーザー名：<%=ud.getName()%><br>
                パスワード：<%=ud.getPassword()%><br>
                メールアドレス：<%=ud.getMail()%><br>
                住所：<%=ud.getAddress()%><br>
                上記の内容で登録しました<br>
                <%=kh.home()%>
            </div>
        <% } else { %>
            エラーが発生しました。
            <%=kh.home()%>
        <% } %>
    </body>
</html>
