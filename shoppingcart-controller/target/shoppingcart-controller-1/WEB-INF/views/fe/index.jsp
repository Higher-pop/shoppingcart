<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" contentType="text/html; UTF-8" %>
<html>
<head>
    <title>商品信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/jquery-3.3.1.js"></script>
    <script src="/static/js/bootstrap.js"></script>


    <style>
        img{
            width:300px;
            height:200px;
            overflow: hidden;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <h1>产品分类</h1>
        </div>
        <div class="col-md-8 column">
            <h1><a href ="/viewcart" class="pull-right">查看购物车
                <span class="badge pull-right " >分类数量：${cart.categoryCount}</span>
                <span class="badge pull-right ">总数量：${cart.itemCount}</span>
            </a></h1>
        </div>
    </div>


    <div class="row clearfix">
        <div class="col-md-2 column">
            <ul class="nav nav-pills nav-stacked">

                <c:forEach var="category" items="${pvo.categories}">
                    <c:choose>
                        <c:when test="${category.cid == pvo.currentCid}" >
                            <li class="active">
                            <!-- /为localhost:8080 -->
                                <a href="/?cid=${category.cid}">${category.cname}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="/?cid=${category.cid}">${category.cname}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>

            </ul>
        </div>


        <div class="col-md-10 column">

            <div class="row">
                <!-- 搜索用get请求。 -->
                <form action="/" method="get">
                    <input type="hidden" name="cid" id="cid" value="${pvo.currentCid}"/>
                    <div class="col-md-10">
                        <!-- 这里利用了el表达式的隐式对象param，
                        param用来读取查询参数，比如url上的查询字符串数据-->
                        <input type="text" name="pname" id="pid" class="form-control center-block" value="${param.pname}"/>
                    </div>

                    <div class="col-md-2">
                        <input type="submit" value="搜索" id="btnSearch" class="btn btn-primary btn-danger "/>
                    </div>

                </form>
            </div>

            <div class="row">
                <c:forEach var="product" items="${pvo.products}">

                    <form method="post" action="/addtocart">

                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img alt="300x200" src="${product.pimage}" />

                                <input type="hidden" name="pid" value="${product.pid}"/>
                                <div class="caption">
                                    <h3>
                                            ${product.pname}
                                    </h3>
                                    <p>
                                        单价：${product.unitprice}
                                    </p>
                                    <p>
                                        <!-- 加上formtarget后以新的选项卡打开页面-->
                                        <%--<input type="submit" formtarget="_blank" value="添加到购物车" class="btn btn-primary"/>--%>

                                        <input type="submit"  value="添加到购物车" class="btn btn-primary"/>
                                    </p>
                                </div>
                            </div>
                        </div>

                    </form>


                </c:forEach>

            </div>

            <div class="row">

                <ul class="pagination pagination-lg">
                    <li>
                        <a href="/?pname=${param.pname}&cid=${pvo.currentCid}&pageno=${pvo.pageInfoes.first}">首页</a>
                    </li>
                    <li>
                        <a href="/?pname=${param.pname}&cid=${pvo.currentCid}&pageno=${pvo.pageInfoes.prev}">上一页</a>
                    </li>
         
                    <li>
                        <a href="/?pname=${param.pname}&cid=${pvo.currentCid}&pageno=${pvo.pageInfoes.next}">下一页</a>
                    </li>
                    <li>
                        <a href="/?pname=${param.pname}&cid=${pvo.currentCid}&pageno=${pvo.pageInfoes.last}">尾页</a>
                    </li>
                </ul>
            </div>
        </div>

    </div>
</div>
</body>
</html>
