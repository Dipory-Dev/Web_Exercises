<%@ page import="com.my.model.dto.MyBoard" %>
<%@ page import="com.my.model.dao.MyBoardDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<html lang="ko">
<head>
    <title>Update Result</title>
</head>
<body>
    <%
        int no = Integer.parseInt(request.getParameter("myno"));
        String title = request.getParameter("mytitle");
        String content = request.getParameter("mycontent");

        MyBoard dto = new MyBoard(no, title, content);
        System.out.println("(((((((((((((((((((())))))))))))))))))");
        System.out.println("update_res dto" + dto);
        MyBoardDao dao = new MyBoardDao();
        int res = dao.update(dto);
        if (res>0) {
    %>
            <h1>업데이트 되었습니다.</h1>
            <button onclick="location.href='selectone.jsp?myno=<%=no%>'">Back</button>
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
