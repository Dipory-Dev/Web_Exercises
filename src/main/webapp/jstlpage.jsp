<%@ page import="java.util.List" %>
<%@ page import="com.el.controller.Score" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 8.
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ko">
<head>
    <title>JSTL Page</title>
</head>
<body>
<%
    List<Score> res = (List<Score>) request.getAttribute("res");
%>
    <h1>JSTL Page</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Kor</th>
            <th>Eng</th>
            <th>Math</th>
            <th>Sum</th>
            <th>AVG</th>
        </tr>
        <c:forEach var="sc" items="${res}">
            <tr>
                <td>
                    <c:if test="${sc.name eq 'name1'}">
                        <c:out value="홍길동"/>
                    </c:if>
                    <c:choose>
                        <c:when test="${sc.name eq 'name2'}">
                            <c:out value="2길동"/>
                        </c:when>
                        <c:when test="${sc.name eq 'name3'}">
                            <c:out value="3길동"/>
                        </c:when>
                        <c:otherwise>
                            <c:out value="나머지 길동"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${sc.kor}</td>
                <td>${sc.eng}</td>
                <td>${sc.math}</td>
                <td>${sc.sum}</td>
                <td>${sc.avg}</td>
            </tr>
        </c:forEach>
    </table>
    <hr>
    <c:forEach var="i" begin="1" end="10" step="1">
        ${i}<br>
    </c:forEach>

    <c:set var="test" value="${res.get(0).name}" scope="session"></c:set>
    <c:out value="${test}"></c:out>

</body>
</html>
