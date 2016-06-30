<%-- 
    Document   : ouyou
    Created on : 2016/06/30, 13:55:35
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<%
    String suu = request.getParameter("suu");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>応用</title>
    </head>
    <body>
        <%
            //String型をInt型へ
            int suuI = Integer.parseInt(suu);
            if(0 >= suuI){
                out.print("整数ではありません");
            }else if(1 == suuI){
                out.print("1");
            }else{

                //素因数用MAP変数
                HashMap<Integer,Integer> soinsuu = new HashMap<Integer,Integer>();

                //2～9までで割り切れる数があるかの検査
                for(int i = 2;i < 10; i++ ){

                    //カウント初期化
                    int j = 0;
                    //割り切れるなら素因数の数をカウント
                    for(j = 0;(suuI % i) == 0; j++){

                        suuI = suuI / i;
                    }

                    //1度でもカウントされたなら素因数とカウント数をsoinsuuへ
                    if(j != 0){

                        soinsuu.put(i, j);          

                    }
                }

                //以下出力処理
                //2～9の間に素因数がない場合
                if(soinsuu.size() == 0){
                    out.print(suuI);

                //2～9の間に素因数があり、2ケタの素因数がある場合
                }else if(suuI >= 10){
                    out.print(suu + " ");

                    for(Map.Entry<Integer,Integer> a : soinsuu.entrySet()){
                        out.print(a.getKey() + "^" + a.getValue() + " ");

                    }
                    out.print(suuI);

                //2～9の間にしか素因数がない場合
                }else{
                    for(Map.Entry<Integer,Integer> a : soinsuu.entrySet()){
                        out.print(a.getKey() + "^" + a.getValue() + " ");

                    }
                }
            }
            
        %>
    </body>
</html>
