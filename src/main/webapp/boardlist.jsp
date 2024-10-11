<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Board List</title>
</head>
<body>
<%
    List<MVCBoardDto> al = (List<MVCBoardDto>) request.getAttribute("allList");
    System.out.println(al);
%>
<h1>All Board List</h1>
<table border="1">
    <col width="50px">
    <col width="100px">
    <col width="200px">
    <col width="100px">
    <tr>
        <th>No.</th>
        <th>Writer</th>
        <th>Title</th>
        <Th>Date</Th>
    </tr>
    <%
        if (al.size() == 0) {
    %>
        <tr>
            <td colspan="4">글이 존재하지 않습니다.</td>
        </tr>
    <%
        } else {
            for (MVCBoardDto dto : al) {
    %>
                <tr>
                    <td><%= dto.getSeq()%></td>
                    <td><%= dto.getWriter()%></td>
                    <td><a href="mycontroller.jsp?command=boarddetail&seq=<%=dto.getSeq()%>"><%= dto.getTitle()%></a></td>
                    <td><%= dto.getRegdate()%></td>
                </tr>
    <%
        }
    }
    %>
    <tr>
        <td colspan="4">
            <input type="button" value="write" onclick="location.href='mycontroller.jsp?command=boardinsertform'">
        </td>
    </tr>
</table>
</body>
</html>
