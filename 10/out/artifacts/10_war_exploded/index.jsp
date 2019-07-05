<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Test</title>
    <script>
      function retrieveTime() {
        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
          if (request.readyState === 4) {
            var result = JSON.parse(request.response);
            var resultString = result.method + "\n" + result.date + "\n" + result.url + "\n" + result.protocol + "\nAddress: " + result.remoteAddress + "\nUser agent: " + result.userAgent;
            alert(resultString);
          }
        };
        request.open("GET", "getTime");
        request.send();
      }
    </script>
  </head>
  <body>
  <button onclick="retrieveTime()">Current time and other data</button>
  <fieldset>
    <legend>Registration</legend>
    <form method="POST" action="register">
      <input name="email" type="text" placeholder="email"/>
      <input name="password" type="password" placeholder="password"/>
      <input type="submit" value="Register"/>
    </form>
  </fieldset>
  <fieldset>
      <legend>Authorize</legend>
      <form method="POST" action="login">
          <input name="email" type="text" placeholder="email"/>
          <input name="password" type="password" placeholder="password"/>
          <input type="submit" value="Sign in"/>
      </form>
  </fieldset>
  </body>
</html>
