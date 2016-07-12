<%-- 
    Document   : jiyuuchou
    Created on : 2016/07/12, 13:02:59
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.nomal.jiyuuchou"%>
<%@page import="java.util.*,java.text.*,java.io.*,javax.servlet.ServletContext"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //ServletContext application = this.getServletContext();
            File txt = new File("C:/Users/You/Desktop/hosokawa/JavaNomalClass/src/java/org/mypackage/nomal/test.txt");//application.getRealPath("test.txt")); 
            FileReader fr = new FileReader(txt);
            BufferedReader br = new BufferedReader(fr);
            out.print(br.readLine());
            
            out.print(application.getRealPath("text.txt"));
            br.close();
            
        %>
    </body>
</html>
