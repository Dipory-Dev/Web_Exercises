<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 10.
  Time: 오후 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Write Form</title>
</head>
<body>
    <h1>Write the board</h1>
    <form action="answer.do?command=boardwrite" method="post">
        <table border="1">
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
                    <input type="button" value="Cancel" onclick="location.href='answer.do?command=list'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
