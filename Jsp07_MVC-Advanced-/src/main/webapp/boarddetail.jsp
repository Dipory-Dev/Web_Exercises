<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 8.
  Time: 오후 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>${res.title}</title>
    <script type="text/javascript">
        function deleteChk(seq) {
            if(window.confirm("삭제 하시겠습니까?")) {
                location.href="controller.do?command=delete&seq=" + seq;
            }
        }
    </script>
</head>
<body>
    <table border="1">
        <tr>
            <th>Seq</th>
            <td>${res.seq}</td>
        </tr>
        <tr>
            <th>Writer</th>
            <td>${res.writer}</td>
        </tr>
        <tr>
            <th>Title</th>
            <td>${res.title}</td>
        </tr>
        <tr>
            <th>Date</th>
            <td>${res.date}</td>
        </tr>
        <tr>
            <th>Content</th>
            <td><textarea cols="40" rows="10" readonly="readonly">${res.content}</textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="button" value="Delete" onclick="deleteChk(${res.seq})">
                <input type="button" value="Edit" onclick="location.href='controller.do?command=updateform&seq=${res.seq}'">
                <input type="button" value="Back" onclick="history.back()">
            </td>
        </tr>
    </table>
</body>
</html>
