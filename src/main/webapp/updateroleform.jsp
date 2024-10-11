<%@ page import="com.login.dto.MyMember" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 1.
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
    <%
        MyMember dto = (MyMember) request.getAttribute("dto");
    %>
    <form action="membercontroller.jsp?command=updaterole" method="post">
        <input type="hidden" name="myno" value="<%=dto.getMyno()%>">
        <table border="1">
            <tr>
                <th>No.</th>
                <td><%=dto.getMyno()%></td>
            </tr>
            <tr>
                <th>Name</th>
                <th><%=dto.getMyname()%></th>
            </tr>
            <tr>
                <th>ID</th>
                <td><%=dto.getMyid()%></td>
            </tr>
            <tr>
                <th>Role</th>
                <td>
                    <select name="myrole">
                        <option value="User" <%= dto.getMyrole().equals("User")? "selected" : ""%>>일반유저</option>
                        <option value="Manager" <%= dto.getMyrole().equals("Manager")? "selected" : ""%>>매니저</option>
                        <option value="Admin" <%= dto.getMyrole().equals("Admin")? "selected" : ""%>>관리자</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Confirm">
                    <input type="button" value="Back" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
