<%@ page import="com.login.dto.MyMember" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 1.
  Time: 오후 4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>User Info</title>
    <script type="text/javascript">
        function deleteuser(myno) {
            if (window.confirm("회원탈퇴 하시겠습니까?")) {
                location.href= "membercontroller.jsp?command=deleteuser&myno=" + myno;
            }
        }
    </script>
</head>
<body>
<% MyMember dto = (MyMember) request.getAttribute("dto"); %>
<h1>My Information</h1>
<table>
    <tr>
        <th>ID</th>
        <td><%= dto.getMyid()%></td>
    </tr>
    <tr>
        <th>PW</th>
        <td><%= dto.getMypw()%></td>
    </tr>
    <tr>
        <th>Name</th>
        <td><%= dto.getMyname()%></td>
    </tr>
    <tr>
        <th>Addr</th>
        <td><%= dto.getMyaddr()%></td>
    </tr>
    <tr>
        <th>Phone</th>
        <td><%=dto.getMyphone()%></td>
    </tr>
    <tr>
        <th>Email</th>
        <td><%= dto.getMyemail()%></td>
    </tr>
    <tr>
        <th>Role</th>
        <td><%= dto.getMyrole().equals("User") ? "일반유저" : "매니저"%></td>
    </tr>
    <tr>
        <td colspan="2" align="right">
            <input type="button" value="탈퇴" onclick="deleteuser(<%=dto.getMyno()%>)">
            <button onclick="history.back()">뒤로가기</button>
        </td>
    </tr>
</table>
</body>
</html>
