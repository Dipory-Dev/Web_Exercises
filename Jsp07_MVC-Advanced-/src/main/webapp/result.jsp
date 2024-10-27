<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 8.
  Time: 오후 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>Result Page</title>
</head>
<body>
    <h1>${msg}</h1>
    <button onclick="location.href='${url}'">Check</button>
</body>
</html>
