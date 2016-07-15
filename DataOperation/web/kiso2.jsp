<%-- 
    Document   : kiso2
    Created on : 2016/07/13, 12:59:17
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("txtName");
    String seibetu = request.getParameter("radioSeibetu");
    String syumi = request.getParameter("txtSyumi");
%>
<html>
    <head>
        
        <%
            Date time = new Date();
            //Cookie宣言
            response.addCookie(new Cookie("LastAccess",time.toString()));
            //Session宣言
            HttpSession hs = request.getSession(true);
            hs.setAttribute("LastAccess",time.toString());
        %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.println("名前:" + name + "<br>");
            out.println("性別:" + seibetu + "<br>");
            out.println("趣味:" + syumi + "<br>");
            
            //Cookie表示
            Cookie cs[] = request.getCookies();
            if(cs!=null){
                for(int i = 0; i < cs.length; i++){
                    if(cs[i].getName().equals("LastAccess")){
                        out.println("<br><br>最終アクセス " + cs[i].getValue());
                        break;
                    };
                }
            }
            
            //Session表示
            out.print("<br><br>最終アクセス(Session) " + hs.getAttribute("LastAccess"));
        %>
    </body>
</html>
