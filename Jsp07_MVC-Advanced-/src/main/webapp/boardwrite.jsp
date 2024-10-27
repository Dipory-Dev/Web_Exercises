<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 8.
  Time: 오후 4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>Write Form</title>
</head>
<body>
    <h1>Write Here</h1>
    <form action="controller.do?command=boardwrite" method="post">
        <table>
            <tr>
                <th>Writer</th>
                <td><input type="text" name="writer"></td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea cols="40" rows="10" name="content"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit">
                    <input type="button" value="Cancel" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
