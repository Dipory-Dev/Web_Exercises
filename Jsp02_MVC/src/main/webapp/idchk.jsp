<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 2.
  Time: 오전 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>ID Check</title>
    <script type="text/javascript">
        function confirm(bool){
            if (bool == "true") {
                opener.document.getElementsByName("mypw")[0].focus();
                opener.document.getElementsByName("myid")[0].title="y";
            } else {
                opener.document.getElementsByName("myid")[0].focus();
            }
            self.close()
        }

        window.onload = function (){
            let id = opener.document.getElementsByName("myid")[0].value;

            document.getElementsByName("id")[0].value = id;
        }
    </script>
</head>
<body>
<%
    String idnotused = request.getParameter("idnotused");
%>

<table>
    <tr>
        <td><input type="text" name="id"></td>
    </tr>
    <tr>
        <td><%= idnotused.equals("true")? "ID생성 가능" : "ID 중복"%></td>
    </tr>
    <tr>
        <td><input type="button" value="Confirm" onclick="confirm('<%=idnotused%>')"></td>
    </tr>
</table>
</body>
</html>
