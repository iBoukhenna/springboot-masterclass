<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
<body>
<form action="/login.do" method="post">
    <p style="color: red;">${errorMessage}</p>
    Enter your name  : <input type="text" name="name" />
    Enter your password  : <input type="password" name="password" />
    <input type="submit" value="login" />
</form>

</body>
</html>
