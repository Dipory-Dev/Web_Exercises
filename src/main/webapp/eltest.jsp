<%@ page import="com.el.controller.Score" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 7.
  Time: 오후 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>El Page</title>
</head>
<body>
<%
    Score score = (Score) request.getAttribute("sc");
%>

    <h1>EL Page</h1>
    <table>
        <tr>
            <th colspan="2"><%=score.getName()%> 님의 점수는...</th>
        </tr>
        <tr>
            <th>Kor</th>
            <td><%=score.getKor()%></td>
        </tr>
        <tr>
            <th>Eng</th>
            <td><%=score.getEng()%></td>
        </tr>
        <tr>
            <th>Math</th>
            <td><%=score.getMath()%></td>
        </tr>
        <tr>
            <th>Sum</th>
            <td>${sc.sum}</td>
        </tr>
        <tr>
            <th>Avg</th>
            <td>${sc.avg}</td>
        </tr>
    </table>
    <hr>
    <c:out value="${test}"/>
</body>
</html>
