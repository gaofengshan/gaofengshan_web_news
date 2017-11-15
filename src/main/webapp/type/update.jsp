
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类别修改页面</title>
    <script type="text/javascript" src="/js/jquery-1.10.1.min.js"></script>
</head>
<body>
<form action="/type/update.html" id = "typeForm" method="post">
            <input type="hidden"  value="${newsType.id}" name="id"/>
    新闻类别：<input type="text" id = "typeName" value="${newsType.typeName}" onblur="check('name')" name="typeName" /><span id = "checkMsg" style="color: red"></span>${error.getFieldError("typeName").defaultMessage}<br/>
    <input type="button" value="修改" id="btn" onclick="check('btn')">
</form>
<script type="text/javascript">
    function check(obj) {
        var typeName = $("#typeName").val();
        $.ajax({
            url:"/type/checktype.html",
            data:"typeName="+typeName,
            method:"post",
            success:function (data) {
                $("#checkMsg").html(data.msg)
                if (data.status == true && obj == "btn") {
                    $("#typeForm").submit();
                }
            }
        })
    }
</script>
</body>
 </html>
