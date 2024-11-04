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
    <title>Update Page</title>
</head>
<h1>Update</h1>
<body>
    <form action="update.do" method="post">
        <input type="hidden" name="myno" value="${dto.myno}">
        <table border="1">
            <tr>
                <th>Writer</th>
                <td>${dto.myname}</td>
            </tr>
            <tr>
                <th>Date</th>
                <td><input type="date" name="mydate" value="${dto.mydate}"></td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input name="mytitle" type="text" value="${dto.mytitle}"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea cols="40" rows="10" name="mycontent">${dto.mycontent}</textarea></td>
            </tr>
            <tr>
                <td colspan="4" align="right">
                    <input type="submit" value="Edit">
                    <input type="button" value="Cancel" onclick="location.href='list.do'"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
