<%-- 
    Document   : ouyou
    Created on : 2016/06/29, 14:10:02
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String syubetu = request.getParameter("syubetu");
    String kosuu = request.getParameter("kosuu");
    String sougaku = request.getParameter("sougaku");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //商品種別判断と出力
            if(syubetu.equals("1")){
                
                out.print("雑貨 ");
            
            }else if(syubetu.equals("2")){
            
                out.print("生鮮食品 ");
            
            }else{
            
                out.print("その他 ");
            
            }
            //String型をInt型へ
            int sougakuI = Integer.parseInt(sougaku);
            int kosuuI = Integer.parseInt(kosuu);
            int point = 0;  //ポイント用変数宣言と初期化
            
            out.print(kosuuI + "点<br>");
            out.print("総額 " + sougakuI + "円<br>");
            out.print("1個当たり " + (sougakuI / kosuuI) + "円<br>");
            
            //ポイント計算　総額5000円以上なら5%　総額3000円以上なら4%
            if(sougakuI >= 5000){
                
                point = sougakuI * 5 / 100;
            
            }else if(sougakuI >= 3000){
                
                point = sougakuI * 4 / 100;
            
            }
            //獲得ポイント出力
            out.print("今回の買い物で獲得したポイントは " + point + "ポイントです。");
            
        %>
    </body>
</html>
