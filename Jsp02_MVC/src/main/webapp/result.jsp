<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 9. 30.
  Time: 오전 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Result Page</title>
</head>
<body>
<%
    String msg = (String)request.getAttribute("msg");
    String url = (String)request.getAttribute("url");
%>

<h1><%=msg%></h1>
<button onclick="location.href='<%=url%>'">Confirm</button>

</body>
</html>
