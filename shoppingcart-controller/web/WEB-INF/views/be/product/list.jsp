<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/jquery-3.3.1.js"></script>
    <script src="/static/js/bootstrap.js"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <h1>产品管理</h1>
        </div>
        <div class="col-md-8 column">
            <hl class="pull-right username">当前用户:${users.username}</hl>

        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
            <ul class="nav nav-pills nav-stacked">
                <li >
                    <a href="/admin/category/index" >分类管理</a>
                </li>
                <li>
                    <a href="/admin/product/index" class="active">产品管理</a>
                </li>


            </ul>
        </div>
        <div class="col-md-10 column">

            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th> 编号</th>
                    <th>名字</th>
                    <th>单价</th>
                    <th> 操作</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pvo.products}" var="product" >
                        <tr>
                            <td>${product.pid}</td>
                            <td>${product.pname}</td>
                            <td>${product.unitprice}</td>
                            <td><a href="/admin/product/edit?pid=${product.pid}"  class="btn btn-info">编辑</a>
                                <a href="/admin/product/delete?pid=${product.pid}" class="btn btn-danger" onclick="return confirm('确定要删除吗？')"
                                    >删除</a><%--  --%>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>

                <tfoot>
                <ul class="pagination pagination-lg">
                    <li>
                        <a href="/admin/product/index?pageno=${pvo.pageInfoes.first}">首页</a>
                    </li>
                    <li>
                        <a href="/admin/product/index?pageno=${pvo.pageInfoes.prev}">上一页</a>
                    </li>
                 
                    <li>
                        <a href="/admin/product/index?pageno=${pvo.pageInfoes.next}">下一页</a>
                    </li>
                    <li>
                        <a href="/admin/product/index?pageno=${pvo.pageInfoes.last}">尾页</a>
                    </li>
                </ul>
                </tfoot>
            </table>

            <a href="/admin/product/add" class="btn btn-info">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <!-- 下面的代码在stackoverflow上看到的水平居中的方法 -->
            <div class="center-block " style="width:400px;max-width:100%;background-color:#ccc;">
                <h3 >没有版权，你想怎么样就怎么样！！</h3>
            </div>

        </div>
    </div>
</div>




</body>
</html>
