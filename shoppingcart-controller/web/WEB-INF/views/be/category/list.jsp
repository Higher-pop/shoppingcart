<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>分类管理</title>
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
            <h1>分类管理</h1>
        </div>

        <div class="col-md-8 column">
            <hl class="pull-right username">当前用户:${users.username}</hl>

        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
            <ul class="nav nav-pills nav-stacked">
                <li class="active">
                    <a href="/admin/category/index" >分类管理</a>
                </li>
                <li>
                    <a href="/admin/product/index">产品管理</a>
                </li>


            </ul>
        </div>
        <div class="col-md-10 column" id="content">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名字</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody> </tbody>
            </table>
            <button href="#" class="btn btn-info add">新增</button>
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


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改分类信息
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">

                    <div class="form-group">
                        <label for="cid" class="col-sm-2 control-label">分类编号</label>
                        <div class="col-sm-10">
                            <input type="text" disabled="disabled" readonly="readonly" class="form-control" id="cid" name="cid" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cname" class="col-sm-2 control-label">分类名字</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cname" name="cname" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" id="save" class="btn btn-default">保存</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

<script src="/static/js/admin/category/list.js"></script>
</body>
</html>
