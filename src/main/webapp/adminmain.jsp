<%@ page import="com.login.dto.MyMember" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 1.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Admin Page</title>
</head>
<body>
<%
    MyMember dto = (MyMember)session.getAttribute("dto");

    if (dto == null) {
        pageContext.forward("index.jsp");
    }
%>
    <h1>Admin Page</h1>
    <div>
        <span><%=dto.getMyname()%>님 환영합니다! (등급 : <%=dto.getMyrole()%>)</span>
        <button onclick="location.href='membercontroller.jsp?command=logout'">Logout</button>
    </div>
    <div>
        <h3><a href="membercontroller.jsp?command=userlistall">회원 정보 조회</a></h3>
    </div>
</body>
</html>
