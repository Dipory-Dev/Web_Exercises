<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 14.
  Time: 오전 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Student Page</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script type="text/javascript">
        function getParameterValues() {
            let name = "name = " + $("#name").val();
            let kor = "kor = " + $("#kor").val();
            let eng = "eng = " + $("#eng").val();
            let math = "math = " + $("#math").val();

            return "?" + name + "&" + kor + "&" + eng + "&" + math;
        }

        $(function() {
            $("#process").click(function () {
                $.ajax({
                    url:"CalScore",
                    dataType:"json",
                    success:function (msg){},
                    error:function(){}
                });
            });
        });
    </script>
</head>
<body>
    <h1>Insert Score</h1>
    <p>Name : <input type="text" id="name"></p>
    <p>Korean : <input type="text" id="kor"></p>
    <p>English : <input type="text" id="eng"></p>
    <p>Math : <input type="text" id="math"></p>
    <input type="button" id="process" value="Processing"><br>
    <hr>
    <div id="res">

    </div>
</body>
</html>
