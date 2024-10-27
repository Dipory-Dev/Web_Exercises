<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 7.
  Time: 오후 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Result Page</title>
</head>
<body>
    <h1>Result</h1>
    <p>pageId : <%=pageContext.getAttribute("pageId")%></p>
    <p>reqId : <%=request.getAttribute("reqId")%></p>
    <p>sessionId : <%=session.getAttribute("sessionId")%></p>
    <p>appId : <%=application.getAttribute("appId")%></p>
    <br>
</body>
</html>
