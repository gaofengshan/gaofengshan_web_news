<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>新闻类别列表</title>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js"></script>

</head>
<body>
<div>
    <a href="/type/add.jsp">添加新闻</a>
    <a href="/index.jsp">首页</a>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <th>类别编号</th>
            <th>类别名称</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${typePage.list}" var="type">
            <tr id = "type_${type.id}">
                <td>${type.id}</td>
                <td>${type.typeName}</td>
                <td><a href="/type/go_update.html?id=${type.id}">修改</a></td>
                <td><a href="javascript:void(0)" onclick="delete_eva(${type.id})">删除</a></td>
                <%--<td><a href="/type/delete/${type.id}.html">删除</a></td>--%>
            </tr>
        </c:forEach>
    </table>
    当前第：${typePage.pageNum}页
    一共：${typePage.pages}页
    <c:if test="${typePage.hasPreviousPage}">
        <a href="/type/list.html?pageNo=${typePage.prePage}" >上一页</a>
    </c:if>
    <c:forEach begin="${typePage.navigateFirstPage}" end="${typePage.navigateLastPage}" var="pn">
        <a href="/type/list.html?pageNo=${pn}"><span style="${shuoPage.pageNum==pn?'color: red':''}">${pn}</span></a>
    </c:forEach>
    <c:if test="${typePage.hasNextPage}">
        <a href="/type/list.html?pageNo=${typePage.nextPage}">下一页</a>
    </c:if>
</div>
<script type="text/javascript">
    $("tr:odd").css("backgroundColor","red");
</script>
<script type="text/javascript">
    function delete_eva(id){
        if(confirm('确认删除吗?将删除此类下的所有新闻')){
            $.ajax({
                type:'post',
                url: "/type/delete.html",
                data:'id='+id,
                success: function(msg){
                        $("#type_"+id).remove();
                }
            });
        }
    }
</script>
</body>
</html>