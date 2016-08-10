<%-- 
    Document   : registration
    Created on : 2016/08/03, 11:20:54
    Author     : You
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="kagoyume.UserData" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("reinput") != null && request.getParameter("reinput").equals("REINPUT")){
        reinput = true;
        ud = (UserData)hs.getAttribute("NewData");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RegistrationConfirm" method="POST">
            ユーザー名：<input type="text" name="txtName" value="<%if(reinput){out.println(ud.getName());}%>"><br>
            パスワード：<input type="text" name="txtPass" value="<%if(reinput){out.println(ud.getPassword());}%>"><br>
            メールアドレス：<input type="text" name="txtMail" value="<%if(reinput){out.println(ud.getMail());}%>"><br>
            住所：<input type="text" name="txtAdd" value="<%if(reinput){out.println(ud.getAddress());}%>"><br>
            <input type="submit" value="登録"><br>
        </form>
        <form action="Login" method="POST">
            <input type="submit" value="戻る">
        </form>
    </body>
</html>
