<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 30.
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>Detail Page</title>
    <script type="text/javascript">
        function del() {
            let chk = confirm("Wanna Delete?")
            if (chk) {
                location.href='delete.do?myno=${dto.myno}'
            }''
        }
    </script>
</head>
<body>
    <table border="1">
        <tr>
            <th>No.</th>
            <td>${dto.myno}</td>
        </tr>
        <tr>
            <th>Writer</th>
            <td>${dto.myname}</td>
        </tr>
        <tr>
            <th>Date</th>
            <td>${dto.mydate}</td>
        </tr>
        <tr>
            <th>Title</th>
            <td>${dto.mytitle}</td>
        </tr>
        <tr>
            <th>Content</th>
            <td><textarea cols="40" rows="10" readonly="readonly">${dto.mycontent}</textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <button onclick="location.href='updateform.do?myno=${dto.myno}'">Edit</button>
                <button onclick="del()">Delete</button>
                <button onclick="location.href='list.do'">Back</button>
            </td>
        </tr>
    </table>
</body>
</html>
