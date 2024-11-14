<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <h1>Update</h1>
    <form action="/myboard/update?myno=${dto.myno}" method="post">
        <table border="1">
            <tr>
                <th>Name</th>
                <td>${dto.myname}</td>
            </tr>
            <tr>
                <th>Date</th>
                <td>${dto.mydate}</td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input name="mytitle" value="${dto.mytitle}"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea name="mycontent" cols="40" rows="10">${dto.mycontent}</textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Edit">
                    <input type="button" value="Cancel" onclick="location.href='/myboard/list'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>