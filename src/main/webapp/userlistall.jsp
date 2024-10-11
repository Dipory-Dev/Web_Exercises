<%@ page import="java.util.List" %>
<%@ page import="com.login.dto.MyMember" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 1.
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Title</title>
    <script type="text/javascript">
        function updaterole(myno) {
            location.href="membercontroller.jsp?command=updateroleform&myno=" + myno;
        }
    </script>
</head>
<body>
<%
    List<MyMember> res = (List<MyMember>) request.getAttribute("list");
%>
<table border="1">
    <tr>
        <th>No.</th>
        <th>ID</th>
        <th>PW</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>E-Mail</th>
        <th>Enable</th>
        <th>Role</th>
        <th>Change</th>
    </tr>
    <%
        for(MyMember m : res) {
    %>
            <tr>
                <td><%=m.getMyno()%></td>
                <td><%=m.getMyid()%></td>
                <td><%=m.getMypw()%></td>
                <td><%=m.getMyname()%></td>
                <td><%=m.getMyaddr()%></td>
                <td><%=m.getMyphone()%></td>
                <td><%=m.getMyemail()%></td>
                <td><%=m.getMyenabled().equals("Y") ? "가입" : "탈퇴"%></td>
                <td><%=m.getMyrole()%></td>
                <td><button onclick="updaterole(<%=m.getMyno()%>);">등급변경</button></td>
            </tr>
    <%
        }
    %>
    <tr>
        <td colspan="10" align="right">
            <button onclick="history.back()">뒤로가기</button>
        </td>
    </tr>
</table>
</body>
</html>
