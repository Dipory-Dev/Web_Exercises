<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detail</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        function del() {
            let chk = confirm("Wanna delete?");
            if (chk) {
                location.href="/myboard/delete?myno=${res.myno}"
            }
        }
    </script>
</head>
<body>
<h1>Detail</h1>
<table border="1">
    <tr>
        <th>No.</th>
        <td>${res.myno}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${res.myname}</td>
    </tr>
    <tr>
        <th>Title</th>
        <td>${res.mytitle}</td>
    </tr>
    <tr>
        <th>Content</th>
        <td><textarea cols="40" rows="10" readonly="readonly">${res.mycontent}</textarea></td>
    </tr>
    <tr>
        <td colspan="2" align="right">
            <button onclick="location.href='/myboard/updateform?myno=${res.myno}'">Edit</button>
            <button onclick="del()">Delete</button>
            <button onclick="location.href='/myboard/list'">Back</button>
        </td>
    </tr>
</table>
</body>
</html>