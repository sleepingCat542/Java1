<%--
  Created by IntelliJ IDEA.
  User: Polina
  Date: 25.04.2019
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Auth</title>
  </head>
  <body>
  <fieldset>
    <legend>Authorize</legend>
    <form method="POST" action="Auth">
      <input name="login" type="text" placeholder="login"/>
      <input name="password" type="password" placeholder="password"/>
      <input type="submit" value="Sign in"/>
    </form>
  </fieldset>

  <br><h2><a href="index.jsp">Task 1</a></h2>
  </body>
</html>
