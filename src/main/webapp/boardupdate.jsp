<%@ page import="com.mvc.dto.MVCBoardDto" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 9. 30.
  Time: 오후 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Update Board</title>
</head>
<body>
<%
    MVCBoardDto dto = (MVCBoardDto) request.getAttribute("dto");
    int seq = dto.getSeq();
%>
<h1>Update</h1>
    <form action="mycontroller.jsp?command=boardupdate&seq=<%=seq%>" method="post">
        <input name="writer" type="hidden" value="<%=dto.getWriter()%>">
        <table border="1">
            <tr>
                <th>Writer</th>
                <td><%=dto.getWriter()%></td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th>Date</th>
                <td><input type="date" name="date"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea cols="40" rows="10" name="content"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Edit">
                    <input type="button" value="Cancle" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
