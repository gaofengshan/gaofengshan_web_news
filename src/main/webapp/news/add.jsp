<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>添加新闻</title>
    <link href="/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="/kindeditor-4.1.10/kindeditor-all-min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/kindeditor-4.1.10/lang/zh_CN.js"></script>
    <script type="text/javascript" src="/js/jquery-1.10.1.min.js"></script>
</head>
<body>
<div class="weizi">
    <div class="wz_text">当前位置：<a href="/index.jsp">首页</a><h1>添加新闻</h1></div>
</div>
<form action="/info/add.html" method="post">
    <input type="hidden" name="userId" value="${user.id}"/><br/>
    新闻类别：<select name = "typeId" >
    <c:forEach items="${typeList}" var="type">
        <option value="${type.id}">${type.typeName}</option>
    </c:forEach></select><br/>
    新闻作者:<input type="text" name="writers" required="required" value="${param.writers}"/><br/>
    新闻标题:<input type="text" name="title" required="required" value="${param.title}"/>${error.getFieldError("title").defaultMessage}<br/>
    新闻正文:<textarea style="width:600px;height:270px;visibility:hidden;" name="contents" id="editor"><value>${param.contents}</value></textarea>
    <input type="submit" value="发布">
</form>

<script type="text/javascript">
    var kingEditorParams ={
        filePostName  : "file",//指定上传文件参数名称
        uploadJson:'/upload2.html',//指定上传文件请求的url。
        dir:"image"//上传类型，分别为image、flash、media、file
    }
    $(function () {
        KindEditor.create($("#editor"),kingEditorParams);
    })
</script>
</div>
</body>
</html>
