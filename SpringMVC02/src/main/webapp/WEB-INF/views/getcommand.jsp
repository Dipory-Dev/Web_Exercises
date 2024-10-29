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
    <title>Command Page</title>
</head>
<body>
    <h1>Get</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Phone</th>
        </tr>
        <tr>
            <td>${dto.name}</td>
            <td>${dto.addr}</td>
            <td>${dto.phone}</td>
        </tr>
    </table>
</body>
</html>
