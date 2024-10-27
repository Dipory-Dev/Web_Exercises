<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Select one Board</title>
</head>
<body>
    <%
        MVCBoardDto dto = (MVCBoardDto) request.getAttribute("dto");
    %>
    <h1>Show Details</h1>
    <table border="1">
        <tr>
            <th>NO.</th>
            <td><%=dto.getSeq()%></td>
        </tr>
        <tr>
            <th>Writer</th>
            <td><%=dto.getWriter()%></td>
        </tr>
        <tr>
            <th>Date</th>
            <td><%=dto.getRegdate()%></td>
        </tr>
        <tr>
            <th>Title</th>
            <td><%=dto.getTitle()%></td>
        </tr>
        <tr>
            <th>Content</th>
            <td><textarea cols="40" rows="10" readonly="readonly"><%=dto.getContent()%></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="Update" onclick="location.href='mycontroller.jsp?command=boardupdateform&seq=<%=dto.getSeq()%>'">
                <input type="button" value="Delete" onclick="location.href='mycontroller.jsp?command=boarddelete&seq=<%=dto.getSeq()%>'">
                <input type="button" value="List" onclick="location.href='mycontroller.jsp?command=boardlist'">
            </td>
        </tr>
    </table>
</body>
</html>
