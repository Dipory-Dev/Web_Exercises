<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 11.
  Time: 오전 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Update Form</title>
</head>
<body>
    <h1>Edit Content</h1>
    <form action="answer.do?command=update&bno=${dto.bno}" method="post">
        <table border="1">
            <tr>
                <th>Writer</th>
                <td>${dto.writer}</td>
            </tr>
            <tr>
                <th>Date</th>
                <td>${dto.regdate}</td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input type="text" name="title" value="${dto.title}"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea name="content" cols="40" rows="10">${dto.content}</textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Edit">
                    <input type="button" value="Cancel" onclick="location.href='answer.do?command=detail&bno=${dto.bno}'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
