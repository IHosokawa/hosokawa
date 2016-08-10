<%-- 
    Document   : search
    Created on : 2016/08/03, 11:19:15
    Author     : You
--%>
<%@page import="net.arnx.jsonic.JSON"
        import="kagoyume.SearchData"
        import="kagoyume.KagoyumeHelper"
        import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    String login = (String)session.getAttribute("Login");
    ArrayList al = (ArrayList)session.getAttribute("ResultData");
    SearchData sd = (SearchData)session.getAttribute("SearchData");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>サーチ結果</title>
    </head>
    <body>
        <%=kh.login(login)%><br>
        検索キーワード：<%=sd.getSearchName()%> 検索結果数：<%=sd.getSearchSum()%><br>
        <table border="1">
            <tr>
                <th>サムネイル</th>
                <th>商品名/価格</th>
            </tr>
            <%for( int i = 0; i < sd.getSearchSum();i++){
                SearchData rd = (SearchData)al.get(i);%>
                <tr>
                    <td  rowspan="2"><a href="Item?id=<%=rd.getItemCode()%>"><img src="<%=rd.getUri()%>"></a></td><!--画像-->
                    <td><a href="Item?id=<%=rd.getItemCode()%>"><%=rd.getName()%></a></td><!--商品名-->
                </tr>
                <tr>
                    <td><%=rd.getPrice()%>円</td><!--価格-->
                </tr>
            <% } %>
        </table><br>
        
    </body>
</html>
