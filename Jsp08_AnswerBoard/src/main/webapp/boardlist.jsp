<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 10.
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
    <h1>글 목록</h1>
    <table border="1">
        <col width="100">
        <col width="300">
        <col width="200">
        <col width="200">
        <tr>
            <th>B_No.</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Date</th>
        </tr>
        <c:choose>
            <c:when test="${empty res}">
                <tr>
                    <td colspan="4">========== No anyboard =========</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="res" items="${res}">
                    <tr>
                        <td>${res.bno}</td>
                        <td>
                            <c:forEach begin="1" end ="${res.titletab}">
                                &nbsp;
                            </c:forEach>

                            <a href="answer.do?command=detail&bno=${res.bno}">${res.title}</a>
                        </td>
                        <td>${res.writer}</td>
                        <td>${res.regdate}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="4" align="right">
                <input type="button" value="Write" onclick="location.href='answer.do?command=writeform'">
            </td>
        </tr>
    </table>
</body>
</html>
