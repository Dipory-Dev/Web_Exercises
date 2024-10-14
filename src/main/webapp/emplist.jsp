<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 14.
  Time: 오후 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>EMP List Page</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#emp_search").click(function (){
               let empid = $("input[name=empid]").val();

               if(empid.length > 2 && empid != "") {
                   $.ajax({
                       url: "emplist.xml",
                       dataType: "xml",
                       success: function (data){
                           let empInfo = $(data).find("EMPLOYEE_ID:contains(" + empid + ")").parent();
                           console.log(empInfo);
                       },
                       error: function (){
                           alert("Error..:(")
                       }
                   })
               } else {
                   alert("Check the emp ID");
               }
            });
        });
    </script>
</head>
<body>
    <h1>Data Check</h1>
    <fieldset>
        <legend>Employee info search</legend>
        <input type="text" name="empid">
        <input type="button" id="emp_search" value="Search">
    </fieldset>
    <hr>
    <table>
        <tr>
            <th>Emp No.</th>
            <td><input type="text" name="emp_no"></td>
        </tr>
        <tr>
            <th>Emp Name</th>
            <td><input type="text" name="lastname"></td>
        </tr>
        <tr>
            <th>E-mail</th>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <th>Hire Date</th>
            <td><input type="text" name="date"></td>
        </tr>
    </table>
</body>
</html>
