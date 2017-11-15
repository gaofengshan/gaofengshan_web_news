<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
    <style type="text/css">
        #code
        {
            font-family:Arial;
            font-style:italic;
            font-weight:bold;
            border:0;
            letter-spacing:2px;
            color:blue;
        }
    </style>
    <script type = "text/javascript" src = "/js/checkCode.js">
    </script>
</head>
<body>
<form action="/user/login.html" method="post">
    <p style="color: red" >${msg}</p>
    用户名：<input type="text" name="name"  required="required"/><br/>
    密码：<input type="password" name="password" required="required"/><br/>
    验证码： <input type = "text" id = "input" required="required"/>
    <input type = "button" id="code" onclick="createCode()"/><span style="font-size: smaller">点击换新</span>
    <input type = "button" value = "验证" onclick = "validate()"/><br/>
    <input type="submit"  id = "btn" disabled=true value="登录"/><br/>
</form>
<a href="/regist.jsp">没有账户 点我注册！</a>
</body>
</html>
