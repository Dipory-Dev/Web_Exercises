<%@ page import="com.my.model.dto.MyBoard" %>
<%@ page import="com.my.model.dao.MyBoardDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<html lang="ko">
<head>
    <%
        int no = Integer.parseInt(request.getParameter("myno"));
        MyBoardDao dao = new MyBoardDao();
        MyBoard b = dao.selectOne(no);

    %>
    <title><%= b.getMytitle()%></title>
</head>
<body>

    <h1>Select One</h1>
    <table>
        <tr>
            <th>Name</th>
            <td><%= b.getMyname()%></td>
        </tr>
        <tr>
            <th>Title</th>
            <td><%= b.getMytitle()%></td>
        </tr>
        <tr>
            <th>Date</th>
            <td><%= b.getMydate()%></td>
        </tr>
        <tr>
            <th>Content</th>
            <td>
                <textarea rows="10", cols="40" readonly="readonly"><%= b.getMycontent()%>
                </textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="button" value="Back"
                       onclick="location.href='mylist.jsp'">
                <input type="button" value="Update"
                       onclick="location.href='update.jsp?myno=<%=b.getMyno()%>'">
                <input type="button" value="Delete"
                       onclick="location.href='delete.jsp?myno=<%=b.getMyno()%>'">
            </td>
        </tr>
    </table>
</body>
</html>
