<%@ page import="com.login.dao.MyMemberDao" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 2.
  Time: 오전 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Regits Form</title>
    <script type="text/javascript">
        function idConfirm() {
            let chk = document.getElementsByName("myid")[0]
            if (chk.title == "n") {
                alert("아이디 중복체크를 해주세요");
                chk.focus();
            }
        }

        function idChk() {
            let doc = document.getElementsByName("myid")[0]
            if (doc.value.trim() == "" || doc.value == null) {
                alert("ID를 입력하세요")
            } else {
                let target = "membercontroller.jsp?command=idchk&myid=" + doc.value.trim();
                window.open(target, "", "width=200, height=200")
            }
            <% MyMemberDao dao = new MyMemberDao();%>
        }
    </script>
</head>
<body>
    <h1>Regist</h1>
    <form action="membercontroller.jsp?command=insertuser" method="post">
        <table border="1">
            <tr>
                <th>ID</th>
                <td>
                    <input type="text" name="myid" title="n" required="required">
                    <input type="button" value="중복체크" onclick="idChk()">
                </td>
            </tr>
            <tr>
                <th>PW</th>
                <td>
                    <input type="password" name="mypw" required="required" onclick="idConfirm()">
                </td>
            </tr>
            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="myname" required="required" onclick="pwConfirm()">
                </td>
            </tr>
            <tr>
                <th>Address</th>
                <td>
                    <input type="text" name="myaddr" required="required" onclick="nameConfirm()">
                </td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>
                    <input type="text" name="myphone" required="required" onclick="addrConfirm()">
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="myemail" required="required" onclick="phoneConfirm()">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="회원가입">
                    <button onclick="history.back()">취소</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
