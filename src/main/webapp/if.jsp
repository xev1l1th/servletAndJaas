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
    String hour = request.getParameter("hour");
    request.setAttribute("hour", hour);
%>
<c:if test="${hour>=10&&hour<=19}">
    ${hour} is a day
</c:if>
</body>
</html>
