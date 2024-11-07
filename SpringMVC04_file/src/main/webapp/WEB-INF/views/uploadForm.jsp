<%@ page import="com.mvc.file.common.UploadFile" %><%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 11. 6.
  Time: 오후 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ko">
<head>
    <title>File Upload</title>
</head>
<body>
    <h1>Upload Form</h1>
    <form:form method="post" action="upload.do" enctype="multipart/form-data" modelAttribute="uploadFile">
        <h3>Select the file to upload</h3>
        File : <input type="file" name="mpfile"><br>
        <p style="color: red; font-weight: bold;">
            <form:errors path="mpfile"></form:errors>
        </p><br>
        <span>Summary : </span><br>
        <textarea rows="10" cols="40" name="desc"></textarea>
        <input type="submit" value="Send">
    </form:form>
</body>
</html>
