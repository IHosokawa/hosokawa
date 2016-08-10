<%-- 
    Document   : registrationconfirm
    Created on : 2016/08/03, 11:21:18
    Author     : You
--%>

<%@page import="kagoyume.UserData"
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="kagoyume.KagoyumeHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    UserData ud = (UserData)session.getAttribute("NewData");
    ArrayList<String> chkList = ud.chkproperties();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(chkList.size()==0){%>
        ユーザー名：<%=ud.getName()%><br>
        パスワード：<%=ud.getPassword()%><br>
        メールアドレス：<%=ud.getMail()%><br>
        住所：<%=ud.getAddress()%><br>
        上記の内容で登録しますか？<br>
        <form action="RegistrationComplete" method="POST">
            <input type="submit" value="はい">
        </form>
        <form action="Registration" method="POST">
            <input type="hidden" name="reinput" value="REINPUT">
            <input type="hidden" name="logac" value="<%=session.getAttribute("logac")%>">
            <input type="submit" value="いいえ">
        </form>
        <%}else{%>
            入力が不十分です<br>
            <%=kh.chkinput(chkList) %>
    <% } %>
    </body>
</html>