<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 11.
  Time: 오전 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>${dto.title}</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>No.</th>
            <td>${dto.bno}</td>
        </tr>
        <tr>
            <th>Writer</th>
            <td>${dto.writer}</td>
        </tr>
        <tr>
            <th>Title</th>
            <td>${dto.title}</td>
        </tr>
        <tr>
            <th>Date</th>
            <td>${dto.regdate}</td>
        </tr>
        <tr>
            <th>Content</th>
            <td><textarea readonly="readonly" rows="10" cols="40">${dto.content}</textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="Edit" onclick="location.href='answer.do?command=updateform&bno=${dto.bno}'">
                <input type="button" value="Reply" onclick="location.href='answer.do?command=answerform&pbno=${dto.bno}'">
                <input type="button" value="List" onclick="location.href='answer.do?command=list'">
            </td>
        </tr>
    </table>
</body>
</html>
