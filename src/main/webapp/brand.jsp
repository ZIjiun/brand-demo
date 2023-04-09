<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%--el 表達式可以活取域中的資料，因此不需要 getattribute--%>
<h1>${user.username}, 歡迎您</h1>

<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序號</th>
        <th>品牌名稱</th>
        <th>企業名稱</th>
        <th>排序</th>
        <th>品牌介紹</th>
        <th>狀態</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>啟用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>

            <%--使用GET請求，將 brand.id 送到 Servlet 去--%>
            <td><a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a> <a href="/brand-demo/deleteByIdServlet?id=${brand.id}">删除</a></td>
        </tr>

    </c:forEach>

</table>

<script>
    document.getElementById("add").onclick = function () {
        location.href = "/brand-demo/addBrand.jsp";
    }
</script>
</body>
</html>