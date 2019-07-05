<%@ page import="db.UserDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <jsp:include page="WEB-INF/views/header.jsp"/>

    <c:set var="name" value="${param.name}"/>
    <c:set var="password" value="${param.password}"/>
    <c:if test="${name != null && password != null}">
        <%
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String errorString = null;
            UserDao userDao = new UserDao();
            if (userDao.isExists(name)) {
                errorString = "This account already exists";
            } else {
                userDao.addUser(name, password);
            }
        %>
    </c:if>
    <%
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String errorString = null;
        if (name != null && password != null) {
            UserDao userDao = new UserDao();
            if (userDao.isExists(name)) {
                errorString = "This account already exists";
            } else {
                userDao.addUser(name, password);
            }
        }

    %>
    <% if (errorString != null) {%>
    <font color="red"></font>
    <%}%>
    <form method="POST" action="register">
        <label>Регистрация нового пользователя</label><br>
        <label>Введите имя: </label><input name="name" type="text"/><br>
        <label>Введите пароль: </label><input name="password" type="password"/><br>
        <input type="submit" value="Зарегистрировать">
    </form>
<jsp:include page="WEB-INF/views/footer.jsp"/>
</body>
</html>
