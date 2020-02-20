<%@ page pageEncoding="UTF-8"  contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>后台管理</title>
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
            <h1>后台管理</h1>
        </div>
        <div class="col-md-8 column">
            <h1 class="pull-right username">当前用户:${users.username}</h1>

        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
            <ul class="nav nav-pills nav-stacked">
                <li>
                    <a href="/admin/category/index">分类管理</a>
                </li>
                <li>
                    <a href="/admin/product/index">产品管理</a>
                </li>
            </ul>
        </div>
        <div class="col-md-10 column">
            <div class="jumbotron">
                <h1>
                    二学期阶段案例!
                </h1>
                <h3>
                    这只是个案例，故意用不同的技术方式完成类似的功能。这是做项目开发时的大忌，切记！
                    <b>真实的项目不是你卖弄技术的地方，是你完成功能，便于以后维护的地方</b>
                </h3>
                <p>
                    这个小案例用来总结展示二学期的一些知识运用，这里是后台管理部分，主要针对产品分类与产品表进行CRUD操作。
                    分类表故意设计为用ajax完成crud操作，而产品表确没有这样设计。产品表要求有分页显示功能
                </p>
                <p>
                    并且后台部分设计为只有登录用户才能访问。
                </p>

                <p>主要用到的技术有：</p>
                <ul>
                    <li><p>jQuery ajax</p></li>
                    <li><p>jackson的序列化</p></li>
                    <li><p>利用过滤器进行简单的权限控制</p></li>
                    <li><p>利用bootstrap进行基本布局处理</p></li>
                </ul>

            </div>

        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <!-- 下面的代码在stackoverflow上看到的水平居中的方法 -->
            <div class="center-block " style="width:400px;
            max-width:100%;
            background-color:#ccc;">
                <h3 >没有版权，你想怎么样就怎么样！！</h3>
            </div>

        </div>
    </div>
</div>

</body>
</html>
