<%--
  Created by IntelliJ IDEA.
  User: 99604
  Date: 2017/10/29
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <style type="text/css">
        td {
            text-align:center; /*设置水平居中*/
            vertical-align:middle;/*设置垂直居中*/
        }
    </style>
</head>
<body>
<a href="/changeUser.jsp">完善个人信息</a><br/>
<a href="/index.jsp">首页</a><br/>
<table cellspacing="0" cellpadding="0" border="1" >
    <tr>
        <td>姓名</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>头像</td>
        <td><img src="http://localhost:8080/upload/${user.avatar}" width="100" height="100" alt="用户头像"/></td>
    </tr>

</table>


</body>
</html>
