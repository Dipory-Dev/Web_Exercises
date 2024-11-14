<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert</title>
</head>
<body>
    <h1>Insert</h1>
    <form action="/myboard/insert" method="post">
        <h1>Insert</h1>
        <table border="1">
            <tr>
                <th>Name</th>
                <td><input type="text" name="myname"></td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input type="text" name="mytitle"></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea cols="40" rows="10" name="mycontent"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Write">
                    <button onclick="location.href='/myboard/list'">Cancel</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>