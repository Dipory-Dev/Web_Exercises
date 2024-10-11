<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>MyMember Login</title>
    <script>
        function registForm() {
            location.href="membercontroller.jsp?command=registform";
        }
    </script>
</head>
<body>
    <div style="width: 300px;">
        <h1 style="text-align: center">Login</h1>
        <form action="membercontroller.jsp" method="post">
            <input type="hidden" name="command" value="login">
            <table>
                <col width="100">
                <col width="100">
                <tr>
                    <th>ID</th>
                    <td><input type="text" name="myid"></td>
                </tr>
                <tr>
                    <th>PW</th>
                    <td><input type="password" name="mypw"></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <input type="submit" value="Login">
                        <input type="button" value="Regist" onclick="registForm();">
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>