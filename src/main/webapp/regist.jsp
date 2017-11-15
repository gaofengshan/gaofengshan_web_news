<%--
  Created by IntelliJ IDEA.
  User: 99604
  Date: 2017/10/29
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript" src="/js/jquery-1.10.1.min.js"></script>
</head>
<body>
<form action="/user/regist.html" id = "userForm" method="post">
    用户名：<input type="text" id = "userName" onblur="check('name')" name="name" /><span id = "checkMsg" style="color: red"></span>${error.getFieldError("name").defaultMessage}<br/>
    密码：<input type="password" name="password"/>${error.getFieldError("password").defaultMessage}<br/>
    确认密码：<input type="password" name="repwd"/><br/>
    <input type="button" value="注册" id="btn" onclick="check('btn')">
</form>
<script type="text/javascript">
    function check(obj) {
        var userName = $("#userName").val();
        $.ajax({
            url:"/user/checkuser.html",
            data:"userName="+userName,
            method:"post",
            success:function (data) {
                $("#checkMsg").html(data.msg)
                if (data.status == true && obj == "btn") {
                    $("#userForm").submit();
                }
            }
        })
    }
</script>
</body>
</html>
