<%--
  Created by IntelliJ IDEA.
  User: 99604
  Date: 2017/10/30
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>新闻详情</title>
    <style type="text/css">
        td {
            text-align:center; /*设置水平居中*/
            vertical-align:middle;/*设置垂直居中*/
        }
    </style>
</head>
<body>
<a href="/index.jsp">首页</a>
<table border="1" cellpadding="0"cellspacing="0">
    <tr>
    <th></th>
    <td></td>
</tr>
    <tr>
        <td>标题</td>
        <td>${newsInfo.title}</td>
    </tr>
    <tr>
    <td>作者</td>
    <td>${newsInfo.writers}</td>
</tr>
    <tr>
        <td>发布时间</td>
        <td><fmt:formatDate value="${newsInfo.createDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
    </tr>
</table>
<div style=" width: 600px;height: 600px;border:1px solid #337FE5">

    ${newsInfo.contents}

</div>
</body>
</html>
