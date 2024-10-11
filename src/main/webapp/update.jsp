<%@ page import="com.my.model.dao.MyBoardDao" %>
<%@ page import="com.my.model.dto.MyBoard" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<html lang="ko">
<head>
    <title>Update Page</title>
</head>
<body>
    <%
        int no = Integer.parseInt(request.getParameter("myno"));
        System.out.println("+++++++++++++++++++++++");
        System.out.println("no : " + no);
        MyBoardDao dao = new MyBoardDao();
        MyBoard dto = dao.selectOne(no);
    %>
    <h1>Update</h1>
    <form action="update_res.jsp" method="post">
        <table>
            <input name="myno" hidden="hidden" value="<%=dto.getMyno()%>">
            <tr>
                <th>Name</th>
                <td><%=dto.getMyname()%></td>
            </tr>
            <tr>
                <th>Title</th>
                <td><input type="text" name="mytitle"></td>
            </tr>
            <tr>
                <th>Date</th>
                <td><%=dto.getMydate()%></td>
            </tr>
            <tr>
                <th>Content</th>
                <td><textarea rows="10" cols="60" name="mycontent"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Edit"
                           onclick="location.href='update_res.jsp?myno=<%=no%>'">
                    <input type="button" value="Cancle"
                           onclick="location.href='selectone.jsp?myno=<%=no%>'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
