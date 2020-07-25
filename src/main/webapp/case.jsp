<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 23.07.2020
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<%
    String degree = request.getParameter("degree");
    request.setAttribute("degree", degree);
%>
<c:choose>
    <c:when test="${degree<15}">cold suka</c:when>
    <c:when test="${degree>15}">hot suka</c:when>
    <c:when test="${degree==15}">zeabook</c:when>
    <c:otherwise>ni4ego ne podowlo</c:otherwise>
</c:choose>
</body>
</html>
