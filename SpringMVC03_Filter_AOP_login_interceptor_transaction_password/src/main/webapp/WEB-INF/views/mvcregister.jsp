<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 11. 5.
  Time: 오전 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Regist Page</title>
</head>
<body>
    <h1>Register</h1>
    <form action="register.do" method="post">
        <table border="1">
            <tr>
                <th>ID</th>
                <td><input type="text" name="memberid"></td>
            </tr>
            <tr>
                <th>PW</th>
                <td><input type="password" name="memberpw"></td>
            </tr>
            <tr>
                <th>Name</th>
                <td><input type="text" name="membername"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Regist">
                    <input type="button" value="Cancel" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
