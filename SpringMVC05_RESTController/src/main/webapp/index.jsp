<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Index</title>
</head>
<body>
    <h1>INDEX</h1>
    <h3><a href="restdto">Select List</a></h3>
    <h3><a href="restdto/1">Select One</a></h3>
    <form action="restdto" method="post">
        <table border="1">
            <tr>
                <th>ID</th>
                <td><input type="text" name="restid"></td>
            </tr>
            <tr>
                <th>PW</th>
                <td><input type="text" name="restpw"></td>
            </tr>
            <tr>
                <th>Name</th>
                <td><input type="text" name="restname"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Insert">
                </td>
            </tr>
        </table>
    </form>

    <form action="restdto/2" method="post">
        <input type="hidden" name="_method" value="delete">
        <button>Delete</button>
    </form>

    <form action="restdto" method="post">
        <input type="hidden" name="_method" value="put">
        <input type="hidden" name="restno" value="3">
        <table border="1">
            <tr>
                <th>PW to change</th>
                <td><input type="password" name="restpw"></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>