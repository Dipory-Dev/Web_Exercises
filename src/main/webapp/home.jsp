<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 7.
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Home</title>
</head>
<body>
    <h1><a href="HelloServlet.do?command=helloGet">Hello</a></h1>
    <br>
    <form action="HelloServlet.do" method="post">
        <input type="hidden" name="command" value="helloPost">
        <input type="submit" value="post">
    </form>
</body>
</html>
