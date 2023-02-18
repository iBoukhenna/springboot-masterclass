<%--
  Created by IntelliJ IDEA.
  User: LENOVO X1 CARBON
  Date: 2/18/2023
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
<body>
<%
    System.out.println("print param : " + request.getParameter("name"));
    Date date = new Date();
%>
<div>Current date is : <%=date%></div>
<br/>
My First JSP ${name}
</body>
</html>
