<%-- 
    Document   : DbAccess11
    Created on : 2016/08/02, 12:07:46
    Author     : You
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ResultDbAccess11_2" method="post">
            名前<input type="text" name="name" value="<%=request.getAttribute("name")%>" ><br>
            電話番号<input type="text" name="tell" value="<%=request.getAttribute("tell")%>"><br>
            年齢<input type="text" name="age" value="<%=request.getAttribute("age")%>"><br>
            生年月日<select name="year">
                <option value="">----</option>
                <%for(int i = 1950; i <= 2016;i++){%>
                <option value="<%=i%>" <%if(request.getAttribute("year").equals(i)){%>selected<%}%>><%=i%></option>
                <%}%>
            </select>年　
            <select name="month">
                <option value="">--</option>
                <%for(int i = 1; i <= 12;i++){%>
                <option value="<%=i%>" <%if(request.getAttribute("month").equals(i)){%>selected<%}%>><%=i%></option>
                <%}%>
            </select>月　
            <select name="day">
                <option value="">--</option>
                <%for(int i = 1; i <= 31;i++){%>
                <option value="<%=i%>" <%if(request.getAttribute("day").equals(i)){%>selected<%}%>><%=i%></option>
                <%}%>
            </select>日<br>
            <input type="hidden" name="profID" value="<%=request.getAttribute("profID")%>">
            <input type="submit" value="送信"><br>
        </form>
    </body>
</html>
