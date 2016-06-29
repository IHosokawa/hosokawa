<%-- 
    Document   : kiso6
    Created on : 2016/06/29, 13:58:50
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int x = 0;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>基礎6</title>
    </head>
    <body>
        <%
            if(x == 1){
                
                out.print("1です！");
            
            }else if(x == 2){
                
                out.print("プログラミングキャンプ！");
                
            }else{
                
                out.print("その他です！");
                
            }
        %>
    </body>
</html>
