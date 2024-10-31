<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 30.
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>Insert Page</title>
</head>
<h1>Insert</h1>
<body>
    <form action="insert.do" method="post">
        <table border="1">
            <tr>
                <th>Writer</th>
                <td><input name="myname" type="text"></td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input name="mytitle" type="text"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea cols="40" rows="10" name="mycontent"></textarea></td>
            </tr>
            <tr>
                <td colspan="4" align="right">
                    <input type="submit" value="Submit">
                    <input type="button" value="Cancel" onclick="location.href='list.do'"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
