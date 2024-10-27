<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 14.
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Emp List 2</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="js/create_table.js"></script>
    <script type="text/javascript">
        $(function (){
           $("#emp_search").click(function (){
               $.ajax({
                   url:"emplist.xml",
                   dataType:"xml",
                   success: function (data){
                       let empRowList = $(data).find("ROW");
                       console.log(empRowList);
                       $("#res").append( makeTable(empRowList));
                   },
                   error: function (){
                       alert("Failed...")
                   }
               })
           });
        });
    </script>
</head>
<body>
    <h1>Load Data</h1>
    <fieldset>
        <legend>All Employees</legend>
        <input type="button" value="Search" id="emp_search">
    </fieldset>
    <hr>
    <div id="res">
    </div>

</body>
</html>
