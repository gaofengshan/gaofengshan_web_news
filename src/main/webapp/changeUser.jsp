<%--
  Created by IntelliJ IDEA.
  User: 99604
  Date: 2017/10/29
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>完善个人信息</title>
    <script type="text/javascript" src="/js/jquery-1.10.1.min.js"></script>
    <link rel="stylesheet" href="/css/jquery.Jcrop.css" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.Jcrop.min.js"></script>
    <style type="text/css">
        .crop_preview {
            position: absolute;
            left: 500px;
            top: 100px;
            width: 100px;
            height: 100px;
            overflow: hidden;
        }
    </style>
</head>
<body>
添加头像：
<input type="file" name="file" id="file"/>
<input type="button" value="上传" onclick="upload()"/>
<div><img id="imgBox" src=""/> <span
        id="preview_box" class="crop_preview"><img id="crop_preview" src=""/></span></div>
<form method="post" id="cutForm">
    <input name="fileName" type="hidden" value="" id="cutFile">
    <b>x1</b><input type="text" size="4" id="x1" name="x1"/>
    <b>y1</b><input type="text" size="4" id="y1" name="y1"/>
    <b>w</b><input type="text" size="4" id="w" name="w"/>
    <b>h</b><input type="text" size="4" id="h" name="h"/>
    <input type="button" value="剪切头像" onclick="cut()"/>
</form>
<form action="/user/change.html" id = "userForm" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <input type="hidden" id ="avatar" name="avatar" value="${user.avatar}">
    更改用户名：<input type="text" id = "userName" value="${user.name}" onblur="check('name')" name="name" /><span id = "checkMsg" style="color: red"></span>${error.getFieldError("name").defaultMessage}<br/>
    <input type="button" value="更改" id="btn" onclick="check('btn')">

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
<script type="text/javascript">
    var jcrop_api = null;
    function upload() {
        var formdata = new FormData();
        if (!$("#file").val()) {
            return;
        }
        formdata.append("key1", "efg");
        formdata.append("file", $("#file")[0].files[0]);//获取文件法
        $.ajax({
            url: '/upload.html',
            type: 'POST',
            data: formdata,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (json) {
                $("#imgBox").attr("src", "http://localhost:8080/upload/" + json);
                $("#crop_preview").attr("src", "http://localhost:8080/upload/" + json);
                $("#avatar").val(json);
                $("#cutFile").val(json);
                $("#imgBox").load(function () {
                    if (jcrop_api != null) {
                        jcrop_api.destroy();
                    }
                    jcrop_api = $.Jcrop("#imgBox", {
                        onChange: showPreview,
                        onSelect: showPreview,
                        aspectRatio: 1
                    });
                });
            }
        });
    }

    function showPreview(coords) {
        if (parseInt(coords.w) > 0) {
            //计算预览区域图片缩放的比例，通过计算显示区域的宽度(与高度)与剪裁的宽度(与高度)之比得到
            var rx = $("#preview_box").width() / coords.w;
            var ry = $("#preview_box").height() / coords.h;
            //通过比例值控制图片的样式与显示
            $("#crop_preview").css({
                width: Math.round(rx * $("#imgBox").width()) + "px",	//预览图片宽度为计算比例值与原图片宽度的乘积
                height: Math.round(rx * $("#imgBox").height()) + "px",	//预览图片高度为计算比例值与原图片高度的乘积
                marginLeft: "-" + Math.round(rx * coords.x) + "px",
                marginTop: "-" + Math.round(ry * coords.y) + "px"
            });
            $("#x1").val(coords.x);
            $("#y1").val(coords.y);
            $("#w").val(coords.w);
            $("#h").val(coords.h);
        }
    }
    function cut() {
        $.ajax({
            url: "/cut.html",
            data: $("#cutForm").serialize(),
            method: "post",
            success: function (data) {
                $("#avatar").val(data);
            }
        })
    }
</script>
</body>
</html>
