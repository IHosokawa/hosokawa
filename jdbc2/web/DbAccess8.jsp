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
            名前<input type="text" name="txtName">
            <input type="submit" value="送信">
        </form>
        <form action="DbAccess9_2" method="post">
            Input
            ID<input type="text" name ="profilesID">
            名前<input type="text" name="txtName">
            電話番号<input type="text" name="tell">
            年齢<input type="text" name="age">
            生年月日<input type="text" name="birthday">
            <input type="submit" value="送信">
        </form>
    </body>
</html>
