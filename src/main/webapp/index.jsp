<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 23.07.2020
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<%
    List<String> tagTypes = Arrays.asList("for", "if", "case", "import");
    request.setAttribute("urls", tagTypes);
%>

<h3>Tag with example for: </h3>
<ur>
    <c:forEach var="url" items="${urls}">
        <li>
            <a href="<c:url value='${url}.jsp'/>">${url}</a>
        </li>
    </c:forEach>
</ur>

</body>
</html>
