<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List</title>
</head>
<body>
    <h1>List</h1>
    <table border="1">
        <colgroup>
            <col width="100">
            <col width="150">
            <col width="200">
            <col width="300">
        </colgroup>
        <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Title</th>
            <th>Date</th>
        </tr>
        <c:forEach var="res" items="${res}">
            <tr>
                <td>${res.myno}</td>
                <td>${res.myname}</td>
                <td><a href="/myboard/detail?myno=${res.myno}">${res.mytitle}</a></td>
                <td>${res.mydate}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" align="right">
                <input type="button" value="Write" onclick="location.href='/myboard/insertform'">
            </td>
        </tr>
    </table>
</body>
</html>