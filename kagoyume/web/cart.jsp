<%-- 
    Document   : cart
    Created on : 2016/08/03, 11:22:54
    Author     : You
--%>
<%@page import="kagoyume.SearchData"
        import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList al = (ArrayList)session.getAttribute("Cart");
    int sum = 0;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カートページ</title>
    </head>
    <body>
        <%
            if(al.size() != 0){
        %>
            <table border="1">
                <tr>
                    <th>サムネイル</th><th colspan="2">名前/価格</th>
                </tr>
                <%for(int i = 0; i < al.size();i++){
                    SearchData sd = (SearchData)al.get(i);%>
                    <tr>
                        <td rowspan="2"><img src="<%=sd.getUri()%>"></a></td><!--画像-->
                        <td><a href="Item?id=<%=sd.getName()%>"><%=sd.getName()%></a></td><!--商品名-->
                        <td rowspan="2">
                            <form action="Delete" method="POST">
                                <input type="submit" value="カートから削除">
                                <input type="hidden" name="deletecode" value="<%=sd.getItemCode()%>">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td><%=sd.getPrice()%>円</td><!--価格-->
                    </tr>
                    <% sum += sd.getPrice(); %>
                <% } %>
            </table>
            合計金額：<%=sum%>円<br>
            <form action="BuyConfirm" method="POST">
                <input type="submit" value="購入する">
            </form>
            <form action="index.jsp" method="POST">
                <input type="submit" value="トップへ戻る">
            </form>
        <%}else{%>
            カートの中身がありません。
            <form action="index.jsp" method="POST">
                <input type="submit" value="トップへ戻る">
            </form>
        <%}%>
        
    </body>
</html>
