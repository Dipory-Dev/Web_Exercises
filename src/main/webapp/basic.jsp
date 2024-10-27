<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 7.
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>EL Page</title>
</head>
<body>
    <h1>EL - Expression Language</h1>
    <table border="1">
        <thead>
            <tr>
                <th>EL Expression</th>
                <th>결과</th>
            </tr>
        </thead>
        <tr>
            <td>\${1}</td>
            <td>${1}</td>
        </tr>
        <tr>
            <td>\${1 + 2}</td>
            <td>${1 + 2}</td>
        </tr>
    </table>
</body>
</html>
