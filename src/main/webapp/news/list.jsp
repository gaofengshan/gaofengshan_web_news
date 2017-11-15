<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>新闻列表</title>
    <style type="text/css">
        #wenzi{
            width:500px; height:82px;overflow:hidden;
        }
    </style>

</head>
<body>

<script type="text/javascript" src="/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.SuperSlide.2.1.1.js"></script>

<!--content start-->
<div id="content">
    <!--left-->
    <div class="left" id="c_left">
        <a href="/info/go_add.html">添加新闻</a>
        <a href="/index.jsp">首页</a>
        <div class="s_tuijian">
            <h2><span>新闻列表</span></h2>
            <form action="/info/list.html" method="post" id="searchForm">
                <input type="hidden" name="pageNo" id="pageNo"/>
                标题：<input name="title" value="${param.title}"/>
                作者：<input name="writers" value="${param.writers}"/><br/>
                发布时间：<input name="minDate" value="${param.minDate}" size="10"/>-
                <input name="maxDate" value="${param.maxDate}"  size="10"/>
                分类：<select name="typeId">
                <option value="">请选择</option>
                <c:forEach items="${typeList}" var="type">
                    <option value="${type.id}" ${param.typeId==type.id?"selected":""}>${type.typeName}</option>
                </c:forEach>
            </select>
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div class="content_text">
            <!--wz-->
            <c:forEach items="${infoList.list}" var="info">
                <div class="wz">
                    <h3><a href="/info/newsInfo.html?id=${info.id}">${info.title}</a></h3>
                    <dl>
                        <dd>
                            <p ><div id = "wenzi" style="border:1px solid #337FE5">${info.contents}</div></p>
                            <p class="dd_text_2">
                                <span class="left author">作者：${info.writers}</span><span class="left sj">&nbsp;&nbsp;&nbsp;&nbsp;时间:<fmt:formatDate value="${info.createDate}" pattern="yyyy-MM-dd hh:mm:ss"/></span>
                                &nbsp;&nbsp;&nbsp;&nbsp;<span class="left fl">分类:${info.gfsNewsCategory.typeName}</span>
                                &nbsp;&nbsp;&nbsp;&nbsp;<span class="left yd"><a href="/info/newsInfo.html?id=${info.id}" title="阅读全文">阅读全文</a></span>
                            <div class="clear"></div>
                        </dd>
                        <div class="clear"></div>
                    </dl>
                </div>
            </c:forEach>
        </div>

        <!--wz end-->
        当前第：${infoList.pageNum}页
        一共：${infoList.pages}页
        <c:if test="${infoList.hasPreviousPage}">
            <a href="javascript: void(0)" onclick="page(${infoList.prePage})" >上一页</a>
        </c:if>
        <c:forEach begin="${infoList.navigateFirstPage}" end="${infoList.navigateLastPage}" var="pn">
            <a href="javascript: void(0)" onclick="page(${pn})"
               class="pageNav  ${infoList.pageNum==pn?'hover':''}">${pn}</a>
        </c:forEach>
        <c:if test="${infoList.hasNextPage}">
            <a href="javascript: void(0)" onclick="page(${infoList.nextPage})">下一页</a>
        </c:if>
        <input type="number" name="pageNo" id="anniu"><input type="button" value="GO" onclick="page(1000)">
    </div>
    <script type="text/javascript">
        function page(obj) {
            var pageIn = $("#anniu").val();
            if (obj == 1000) {
                obj = pageIn;
            }
            if (obj == null || isNaN(obj) || obj < 0) {
                obj = 1;
            }
            $("#pageNo").val(obj);

            $("#searchForm").submit();
        }
    </script>

        </div>
    </div>
    <div class="clear"></div>
    <div class="clear"></div>
</div>
</body>
</html>