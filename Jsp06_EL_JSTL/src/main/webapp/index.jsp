<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Index</title>
</head>
<body>
    <a href="controller.do?command=elpage">EL(Expression Language)</a>
    <br>
    <a href="controller.do?command=eltest">EL Test(Expression Language)</a>
    <br>
    <a href="controller.do?command=jstlpage">JSTL(JSP Standard Tag Library)</a>
</body>
</html>