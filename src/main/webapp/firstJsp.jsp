<%@ page import="com.artem.domain.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 22.07.2020
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>
    Hello JSP
</h1>
<%
    response.getWriter().write("first message");
    out.print("after jsp");
%>


<%=request.getRequestURI() + " " + request.getServerName()
%>
<hr/>

<%
    List<User> userList = (List<User>) request.getAttribute("users");
    User first = userList.get(0);
%>

<table>
    <% for(User user:userList){%>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getCountry()%></td>
            <td><%=user.getAge()%></td>
        </tr>
    <%}%>
</table>

</body>
<head>
    <title>Title</title>
</head>
</html>
