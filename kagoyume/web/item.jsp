<%-- 
    Document   : item
    Created on : 2016/08/03, 11:19:29
    Author     : You
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="kagoyume.SearchData"
        import="kagoyume.KagoyumeHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    KagoyumeHelper kh = KagoyumeHelper.getInstance();
    String login = (String)session.getAttribute("Login");
    String coming = (String)session.getAttribute("Coming");                     //どのページから遷移してきたか
    String detailID =(String)session.getAttribute("DetailId");                  //クリックされた商品コード
    SearchData sdA = null;
    if(coming.equals("search")){
        ArrayList al = (ArrayList)session.getAttribute("ResultData");           //searchからアクセスした場合検索データから検索
        for(int i = 0; i < al.size(); i++){                                     
            sdA = (SearchData)al.get(i);
            if(sdA.getItemCode().equals(detailID)){
                break;
            }
        }
    }else if(coming.equals("cart")){
        ArrayList al = (ArrayList)session.getAttribute("Cart");                 //cartからアクセスした場合カートデータから検索
        for(int i = 0; i < al.size(); i++){
            sdA = (SearchData)al.get(i);
            if(sdA.getItemCode().equals(detailID)){
                break;
            }
        }
    }
    SearchData sdSd = (SearchData)session.getAttribute("SearchData");           //入力された検索データ
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=kh.login(login)%><br>
        <% if(sdA != null){ %>
            <Div Align="center">
                <image src="<%=sdA.getUri()%>"><br>
                <table border="1" width="600">
                    <tr>
                        <th width="15%">名前</th><td width="45%" colspan="2"><%=sdA.getName()%></td>
                    </tr>
                    <tr>
                        <th>価格</th><td colspan="2"><%=sdA.getPrice()%>円</td>
                    </tr>
                    <tr>
                        <th>商品概要</th><td colspan="2"><%=sdA.getDescription()%></td>
                    </tr>
                    <tr>
                        <th>商品評価<br>/レビュー数</th><td><%=sdA.getReviewRate()%></td><td><%=sdA.getReviewCount()%></td>
                    </tr>
                </table>
            </Div>
            <% if(coming.equals("search")){%>
                <form action="Add" method="POST">
                    <input type="submit" value="カートに追加する">
                    <input type="hidden" name="detailid" value="<%=sdA%>">
                </form>
                <form action="Search" method="GET">
                    <input type="submit" value="検索画面へ戻る">
                    <input type="hidden" name="keyword" value="<%=sdSd.getSearchName()%>">
                </form>
            <% }else if(coming.equals("cart")){ %>
                <form action="Add" method="POST">
                    <input type="submit" value="カートに追加する">
                    <input type="hidden" name="detailid" value="<%=sdA%>">
                </form>
                <form action="Cart" method="POST">
                    <input type="submit" value="カートへ戻る">
                </form>
        <% }}else{ %>
            不正なアクセスです。
            <form action="index.jsp" method="POST">
                <input type="submit" value="トップへ戻る">
            </form>
        <% } %>
    </body>
</html>
