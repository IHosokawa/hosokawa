<%-- 
    Document   : UserDataResult
    Created on : 2016/07/04, 14:03:17
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.kiso3_1_4.ResultUserData"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%
            ResultUserData data = (ResultUserData)request.getAttribute("Data");
        %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data.isI() == true){
                out.print("この処理は正しく実行されました。");
                /*
                if(data != null){
                    for(int j = 0; j < 10;j++){
                        for(int i = 0; i < data.getI(); i++){
                            out.println(data.getUser()[i] + "<br>");
                        }
                    }
                }*/

            }else{
                out.println("正しく実行されませんでした。");
            }
        %>
        <h1>Hello World!</h1>
    </body>
</html>
