<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Index Page</title>
</head>
<body>
    <h1>Index</h1>
    <a href="controller.do?command=list">All Lists</a>
</body>
</html>