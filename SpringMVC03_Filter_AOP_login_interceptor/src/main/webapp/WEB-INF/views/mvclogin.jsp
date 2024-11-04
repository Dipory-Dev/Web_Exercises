<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 11. 1.
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Login Page</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#loginChk").hide();
        });

        const login = () => {
            let memberid = $("#memberid").val().trim();
            let memberpw = $("#memberpw").val().trim();
            console.log(memberid + " / " + memberpw);

            let loginVal = {
                "memberid" : memberid,
                "memberpw" : memberpw
            }

            if (memberid == "" || memberpw == "") {
                alert("Check the ID or PW.");
            } else {
                $.ajax({
                    type : "post",
                    url : "ajaxlogin.do",
                    data : JSON.stringify(loginVal),
                    contentType : "application/json",
                    dataType : "json",
                    success : function (msg) {
                        console.log(msg);
                        if(msg.login == true) {
                            location.href="list.do";
                        } else {
                            $("#loginChk").show();
                            $("#loginChk").html("Wrong value of ID or PW.")
                        }
                    },
                    error : function () {
                        alert("AJAX Connect Failed...")
                    }
                })
            }
        }
    </script>
</head>
<body>
    <h1>Login</h1>
    <table>
        <tr>
            <th>ID</th>
            <td><input id="memberid" type="text" name="memberid"></td>
        </tr>
        <tr>
            <th>PW</th>
            <td><input id="memberpw" type="password" name="memberpw"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" value="Login" onclick="login();"></td>
        </tr>
        <tr>
            <td colspan="2" align="center" id="loginChk"></td>
        </tr>
    </table>
</body>
</html>
