<%-- 
    Document   : kiso3
    Created on : 2016/07/13, 13:56:13
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Date time = new Date();
            Cookie c = new Cookie("LastLogin", time.toString());
            response.addCookie(c);
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie cs[] = request.getCookies();
            if(cs!=null){
                for(int i = 0;i < cs.length ;i++){
                    if(cs[i].getName().equals("LastLogin")){
                        out.println("最終ログイン時間" + cs[i].getValue());
                        break;
                    }
                }
            }
        %>
    </body>
</html>
