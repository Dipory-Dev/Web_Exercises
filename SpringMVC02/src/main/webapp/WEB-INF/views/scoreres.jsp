<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 29.
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Score Page</title>
</head>
<body>
    <h1>Score</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Kor</th>
            <th>Eng</th>
            <th>Math</th>
        </tr>
        <tr>
            <td>${dto.name}</td>
            <td>${dto.kor}</td>
            <td>${dto.eng}</td>
            <td>${dto.math}</td>
        </tr>
    </table>
</body>
</html>
