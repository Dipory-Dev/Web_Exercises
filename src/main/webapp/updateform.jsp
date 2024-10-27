<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 10.
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>Update Form</title>
</head>
<body>
    <h1>Update Data..</h1>
    <form action="controller.do?command=update&seq=${dto.seq}" method="post">
        <table border="1">
            <tr>
                <th>No.</th>
                <td>${dto.seq}</td>
            </tr>
            <tr>
                <th>Date</th>
                <td><input type="date" name="date"></td>
            </tr>
            <tr>
                <th>Writer</th>
                <td>${dto.writer}</td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input type="text" name="title" value="${dto.title}"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea cols="40" rows="10" name="content">${dto.content}</textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Edit">
                    <input type="button" value="Cancel" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
