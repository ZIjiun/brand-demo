<%--
  Created by IntelliJ IDEA.
  User: Zijun
  Date: 2023/4/10
  Time: 上午 07:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>歡迎註冊</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>歡迎註冊</h1>
        <span>已有帳號？</span> <a href="login.html">登錄</a>
    </div>
    <form id="reg-form" action="/brand-demo/registerServlet" method="post">

        <table>

            <tr>
                <td>使用者名稱</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${register_msg}</span>
                </td>

            </tr>

            <tr>
                <td>密碼</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密碼格式有誤</span>
                </td>
            </tr>


            <tr>
                <td>驗證碼</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img src="imgs/a.jpg">
                    <a href="#" id="changeImg">看不清楚？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="註 冊" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>
</body>
</html>