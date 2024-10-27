<%@ page import="com.my.model.dao.MyBoardDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
    <%
        int no = Integer.parseInt(request.getParameter("myno"));
        MyBoardDao dao = new MyBoardDao();
        int res = dao.delete(no);
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("delete.jsp : " + res);
        System.out.println("++++++++++++++++++++++++++++");
        if (res > 0) {
    %>
    <h1>삭제되었습니다.</h1>
    <button onclick="location.href='mylist.jsp'">Back</button>
    <%
        } else {
    %>
    <h1>에러발생.</h1>
    <button onclick="location.href='mylist.jsp'">Back</button>
    <%
        }
    %>

</body>
</html>
