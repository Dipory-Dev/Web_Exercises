<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 11. 6.
  Time: 오후 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Result</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>File name</th>
            <td>${fileobj.filename}</td>
        </tr>
        <tr>
            <th>Description</th>
            <td>${fileobj.desc}</td>
        </tr>
    </table>
</body>
</html>
