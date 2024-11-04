<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 30.
  Time: 오후 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>MVC List Page</title>
</head>
<body>
    <h1>List</h1>
<%--    <h2>Hello! ${login.membername}</h2>--%>
    <table border="1">
        <colgroup>
            <col width="50"/>
            <col width="100"/>
            <col width="300"/>
            <col width="100"/>
        </colgroup>
        <tr>
            <th>No.</th>
            <th>Writer</th>
            <th>Title</th>
            <th>Date</th>
        </tr>
        <c:choose>
            <c:when test="${empty res}">
                <tr>
                    <td colspan="4" align="center">---------- No Data ----------</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${res}" var="dto">
                    <tr>
                        <td>${dto.myno}</td>
                        <td>${dto.myname}</td>
                        <td><a href="detail.do?myno=${dto.myno}">${dto.mytitle}</a></td>
                        <td>${dto.mydate}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="4" align="right">
                <input type="button" value="Write" onclick="location.href='insertform.do'"/>
            </td>
        </tr>
    </table>
</body>
</html>
