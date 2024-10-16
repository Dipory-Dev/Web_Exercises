<%@ page import="com.my.model.dto.MyBoard" %>
<%@ page import="com.my.model.dao.MyBoardDao" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>

<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
    <%
        //1. request를 이용하여 파라미터로 넘어오는 데이터 수신
        String myname = request.getParameter("myname");
        String mytitle = request.getParameter("mytitle");
        String mycontent = request.getParameter("mycontent");

        MyBoard dto = new MyBoard(myname, mytitle, mycontent);

        //2. DB에 저장
        MyBoardDao dao = new MyBoardDao();
        int res = dao.insert(dto);

        if (res > 0) {
    %>
            <script type="text/javascript">
                alert("Successfully added MyBoard")
                location.href="mylist.jsp";
            </script>
    <%
        } else {
    %>
            <script type="text/javascript">
                alert("Failed added MyBoard")
                location.href="myinsert.jsp";
            </script>
    <%
        }
    %>
</body>
</html>