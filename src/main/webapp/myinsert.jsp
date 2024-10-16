<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Insert page</title>
</head>
<body>
    <h1>Write</h1>
    <form action="myinsert_res.jsp" method="post">
        <table>
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
                <td><textarea rows="10" cols="60" name="mycontent"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Write">
                    <input type="button" value="Cancle"
                           onclick="location.href='mylist.jsp'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
