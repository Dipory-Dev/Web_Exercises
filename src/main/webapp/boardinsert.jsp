<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 9. 30.
  Time: 오전 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Insert to Board</title>
</head>
<body>
    <h1>Write</h1>
    <form action="mycontroller.jsp?command=boardinsert" method="post">
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
                <td colspan="2" align="right">
                    <input type="submit" value="Write">
                    <input type="button" value="Cancle" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
