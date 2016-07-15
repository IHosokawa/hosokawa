<%-- 
    Document   : ouyou
    Created on : 2016/07/13, 14:52:25
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%
                HttpSession hs = request.getSession(true);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="test" action="./ouyou2.jsp" method="post">
            <%/*
                //確認用出力
                out.print(hs.getAttribute("Sei"));
            */%>
            <table>
                <div>名前：<input type="text" name="txtName" value="<%= hs.getAttribute("Name") %>" ></div>
                <div>性別：<input type="radio" name="radioSei" value="男"
                       <% if(hs.getAttribute("Sei")!=null && hs.getAttribute("Sei").equals("男")){ %>checked<% }; %> >男
                <input type="radio" name="radioSei" value="女"
                       <% if(hs.getAttribute("Sei")!=null && hs.getAttribute("Sei").equals("女")){ %>checked<% }; %> >女</div>
                <div>趣味：<textarea name="mulText" ><% out.println(hs.getAttribute("Syumi")); %></textarea></div>
            <input type="submit" value="送信">
            </table>
        </form>
            
        <%/*
            String name = request.getParameter("txtName");
            hs.setAttribute("Name",name);
            out.println(hs.getAttribute("Name"));
        */%>
    </body>
</html>
