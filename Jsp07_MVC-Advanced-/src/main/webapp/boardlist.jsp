<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MyMVC" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 8.
  Time: 오후 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>Board Lists</title>
</head>
<body>
    <table border="1">
        <col width="50">
        <col width="100">
        <col width="300">
        <col width="100">
        <tr>
            <th>No.</th>
            <th>Writer</th>
            <th>Title</th>
            <th>Date</th>
        </tr>
        <c:choose>
            <c:when test="${empty res}">
                <tr>
                    <td colspan="4">---- No content in the board ----</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="ls" items="${res}">
                    <tr>
                        <td>${ls.seq}</td>
                        <td>${ls.writer}</td>
                        <td><a href="controller.do?command=detail&seq=${ls.seq}">${ls.title}</a></td>
                        <td>${ls.date}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="4" align="right">
                <input type="button" value="Write" onclick="location.href='controller.do?command=writeform'">
            </td>
        </tr>
    </table>
</body>
</html>
