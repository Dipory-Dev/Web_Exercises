<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <h2><a href="test.do">Home</a></h2>
        <h2><a href="command.do?name=spring&addr=seoul&phone=010-1234-1234">Get Command</a></h2>

        <hr>
        <form action="command.do" method="post">
            <table border="1">
                <tr>
                    <th>Name</th>
                    <td><input name="name" type="text"></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td><input name="addr" type="text"></td>
                </tr>
                <tr>
                    <th>Phone</th>
                    <td><input name="phone" type="text"></td>
                </tr>
                <tr>
                    <td colspan="2"><input value="Post Submit" type="submit"></td>
                </tr>
            </table>
        </form>

        <form action="score.do" method="post">
            <table border="1">
                <tr>
                    <th>Name</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>Kor</th>
                    <td><input type="text" name="kor"></td>
                </tr>
                <tr>
                    <th>Eng</th>
                    <td><input type="text" name="eng"></td>
                </tr>
                <tr>
                    <th>Math</th>
                    <td><input type="text" name="math"></td>
                </tr>
                <tr>
                    <td colspan="2"><input value="Submit" type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>