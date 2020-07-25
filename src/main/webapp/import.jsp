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
<c:url value="title.jsp" var="importUrl">
    <c:param name="pageName" value="importTempPage" />
</c:url>
<h1>Main Page</h1>
<c:import url="${importUrl}" />
</body>
</html>
