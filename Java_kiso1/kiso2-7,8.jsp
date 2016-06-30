<%-- 
    Document   : kiso2-7
    Created on : 2016/06/30, 10:45:45
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>基礎2-7</title>
    </head>
    <body>
        <%
            int[] nArr = new int[5];
            int nArr2[] = {1,2,3,4,5};
            
            out.println(nArr.toString());           //出力結果 [I@20460
            out.println(nArr2.toString() + "<br>"); //出力結果 [I@7f6fe0
            
            String a[] = {"10","100","soeda","hayashi","-20","118","END"};
            out.println(a.toString());               //[Ljava.lang.String;@1343a03
            for(int i=0;i<a.length;i++){
                out.println(a[i] + ",");            //10, 100, soeda, hayashi, -20, 118, END,   
            }
            
            //課題8
            a[2] = "33";
            for(int i=0;i<a.length;i++){
                out.println(a[i] + ",");            //10, 100, 33, hayashi, -20, 118, END,   
            }
        %>
    </body>
</html>
