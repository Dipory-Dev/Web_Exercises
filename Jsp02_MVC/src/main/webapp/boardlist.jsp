<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <title>Board List</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script type="text/javascript">
        $("#muldelform").submit(function (){
            if($("#muldelform input:checked").length == 0) {
                alert("Nothing to Delete.")
                return false;
            }
        })
    </script>
</head>
<body>
<%
    List<MVCBoardDto> al = (List<MVCBoardDto>) request.getAttribute("allList");
    System.out.println(al);
%>
    <h1>All Board List</h1>
    <form action="mycontroller.jsp?command=muldel" method="post" id="muldelform">
        <table border="1">
            <col width="50px">
            <col width="100px">
            <col width="200px">
            <col width="100px">
            <tr>
                <th></th>
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
                            <td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"></td>
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
                    <input type="submit" value="Delete">
                    <input type="button" value="write" onclick="location.href='mycontroller.jsp?command=boardinsertform'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
