<%@ page import="com.artem.authentication.Authentication" %><%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 24.07.2020
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<form method="post" action="/myApp/login">
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <button type="submit">Send</button>
</form>
<%
    Authentication authentication = (Authentication) request.getAttribute("auth");
    request.setAttribute("auth", authentication);
%>
<c:if test="${auth!=null}">
    ${auth}
</c:if>
</body>
</html>
