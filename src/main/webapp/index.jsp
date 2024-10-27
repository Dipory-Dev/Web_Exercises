<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<html lang="ko">
<head>
    <title>Main</title>
</head>
<body>
    <%
        pageContext.setAttribute("pageId", "myPageIdVal");
        request.setAttribute("reqId", "myRequestIdVal");
        session.setAttribute("sessionId", "mySessionIdVal");
        application.setAttribute("appId", "myAppIdVal");
    %>
    <h1>Index</h1>
    <p>pageId : <%=pageContext.getAttribute("pageId")%></p>
    <p>reqId : <%=request.getAttribute("reqId")%></p>
    <p>sessionId : <%=session.getAttribute("sessionId")%></p>
    <p>appId : <%=application.getAttribute("appId")%></p>
    <br>
    <h3><a href="result.jsp">result 창</a></h3>
    <h3><a href="myservlet.do">컨트롤러 이동</a></h3>
</body>
</html>