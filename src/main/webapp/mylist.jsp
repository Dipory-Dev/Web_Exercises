<%@ page import="com.my.model.dao.MyBoardDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.my.model.dto.MyBoard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<html lang="ko">
<head>
    <title>mylist</title>
</head>
<body>
    <%
        MyBoardDao dao = new MyBoardDao();
        List<MyBoard> list = dao.selectAll();
        for (MyBoard board : list) {
            System.out.println(board);
        }
    %>
    <h1>My List Page</h1>
    <table border="1">
        <col width="50px">
        <col width="100px">
        <col width="300px">
        <col width="300px">
        <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Title</th>
            <th>Date</th>
            <th>Delete</th>
        </tr>
        <%
            for (int i = 0; i < list.size(); i++) {
        %>
                <tr>
                    <td><%= list.get(i).getMyno() %></td>
                    <td><%= list.get(i).getMyname() %></td>
                    <td><a href="selectone.jsp?myno=<%=list.get(i).getMyno()%>"><%= list.get(i).getMytitle() %></a></td>
                    <td><%= list.get(i).getMydate() %></td>
                    <td><button onclick="location.href='delete.jsp?myno=<%=list.get(i).getMyno()%>'">Delete</button></td>
                </tr>
        <%
            }
        %>
        <tr>
            <td>
                <button onclick="location.href='myinsert.jsp'">WRITE</button>
            </td>
        </tr>
    </table>
</body>
</html>
