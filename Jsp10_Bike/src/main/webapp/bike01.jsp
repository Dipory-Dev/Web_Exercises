<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 14.
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Bike 01</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script type="text/javascript" src="js/bike01.js"></script>
</head>
<body>
    <h1>Bike 01</h1>
    <form action="bike?command=first_db" method="post">
        <input type="submit" value="Save">

        <table border="1">
            <thead></thead>
            <tbody></tbody>
        </table>
    </form>
</body>
</html>
