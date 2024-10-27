<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 11.
  Time: 오후 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Answer</title>
</head>
<body>
    <form action="answer.do?command=answerwrite&pbno=${dto.bno}" method="post">
        <table border="1">
            <tr>
                <th>Writer</th>
                <td><input type="text" name="writer"></td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input type="text" name="title" readonly="readonly" value="Re:${dto.title} "></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea name="content" rows="10" cols="40"></textarea></td>
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
