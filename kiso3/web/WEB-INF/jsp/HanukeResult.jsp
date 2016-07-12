<%-- 
    Document   : HanukeResult
    Created on : 2016/07/05, 12:53:14
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="org.mypackage.kiso3_7_8.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultHanuke data = (ResultHanuke)request.getAttribute("Data");
            hanuke data2 = new hanuke();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data != null){
                // 1人分のデータ領域
                for( int i = 0;i < (data2.limit * 4) ;i=i+4){
                    // IDを飛ばして情報を出力
                    for(int j = 1; j < 4;j++){
                        // 中身がnullなら飛ばす
                        if(data.getIndex()[i+j] != null){
                            out.println(data.getIndex()[i+j]);
                        }else{
                            continue;
                        }
                    }
                }
            }
        %>
        <h1>Hello World!</h1>
    </body>
</html>
