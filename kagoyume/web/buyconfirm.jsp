<%-- 
    Document   : buyconfirm
    Created on : 2016/08/03, 11:23:20
    Author     : You
--%>
<%@page import="kagoyume.SearchData"
        import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList al = (ArrayList)session.getAttribute("Cart");
    int sum = 0;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入確認画面</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>名前</th><th>価格</th>
            </tr>
            <%for(int i = 0; i < al.size();i++){
                SearchData sd = (SearchData)al.get(i);%>
                <tr>
                    <td><%=sd.getName()%></td><td><%=sd.getPrice()%></td>
                </tr>
                <% sum += sd.getPrice();    //合計金額の計算
            } %>
            
        </table>
        合計金額：<%=sum%>円<br>
        発送方法<%//ここに発送方法を記述%>
        <form action="BuyComplete" method="POST">
            <input type="submit" value="上記の内容で購入する">
        </form>
        <form action="Cart" method="POST">
            <input type="submit" value="カートへ戻る">
        </form>
        <form action="index.jsp" method="POST">
            <input type="submit" value="トップへ戻る">
        </form>
    </body>
</html>
