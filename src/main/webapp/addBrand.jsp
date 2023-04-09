<%--
  Created by IntelliJ IDEA.
  User: Zijun
  Date: 2023/4/9
  Time: 下午 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h3>增加品牌</h3>
<form action="/brand-demo/addServlet" method="post">
    品牌名稱: <input name="brandName"><br>
    企業名稱: <input name="companyName"><br>
    排序: <input name="ordered"><br>
    描述訊息: <input name="description"><br>
    狀態:
        <input type="radio" name="status" value="0"> 禁用
        <input type="radio" name="status" value="1"> 啟用
    <input type="submit" value="提交">
</form>

<body>

</body>
</html>
