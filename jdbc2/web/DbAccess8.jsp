<%-- 
    Document   : DbAccess8
    Created on : 2016/07/22, 16:17:27
    Author     : You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="DbAccess8_2" method ="post">
            insert<br>
            名前<input type="text" name="txtName"><br>
            <input type="submit" value="送信"><br>
        </form>
        <form action="DbAccess9_2" method="post">
            <br>Input<br>
            ID<input type="text" name ="profilesID"><br>
            名前<input type="text" name="txtName"><br>
            電話番号<input type="text" name="tell"><br>
            年齢<input type="text" name="age"><br>
            生年月日<select name="year">
            <option value="">----</option>
                <% for(int i=1950; i<=2010; i++){ %>
                <option value="<%=i%>" ><%=i%></option>
                <% } %>
            </select>年
            <select name="month">
                <option value="">--</option>
                <% for(int i = 1; i<=12; i++){ %>
                <option value="<%=i%>" ><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <% for(int i = 1; i<=31; i++){ %>
                <option value="<%=i%>" ><%=i%></option>
                <% } %>
            </select>日<br>
                <input type="submit" value="送信"><br>
        </form>
        <form action="DbAccess10_2" method="post">
            <br>delet<br>
            ID<input type="text" name="profilesID"><br>
            <input type="submit" value="送信"><br>
        </form>
        <form action="DbAccess11_2" method="post">
            <br>update<br>
            ID<input type="text" name="profilesID">
            <input type="submit" value="送信">
        </form>
    </body>
</html>
