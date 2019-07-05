<%@ page import="db.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 5/3/19
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("email");//("name")
    String password = request.getParameter("password");
    String errorString = null;
    if (name != null && password != null)
    {
        UserDao userDao = new UserDao();
        if (!userDao.checkFor(name, password)) {
            errorString = "Неверный логин или пароль";
        } else {
            session.setAttribute("name", name);
            response.sendRedirect("welcome");
        }
    }
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="WEB-INF/views/header.jsp"/>
    <% if (errorString != null) {%>
    <font color="red"><%=errorString%></font>
    <%}%>
    <br><label>Вход в систему</label>
    <form>
        <label>Имя: </label><input type="text" name="name"/><br/>
        <label>Пароль: </label><input type="password" name="password"/><br/>
        <input type="submit" value="Войти"/>
    </form>
    <button onclick="window.open('register');">Регистрация</button>
    <jsp:include page="WEB-INF/views/footer.jsp"/>
</body>
</html>
