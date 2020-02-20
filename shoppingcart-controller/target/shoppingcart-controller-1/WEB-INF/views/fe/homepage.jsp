<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>主页</title>
 	<link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/jquery-3.3.1.js"></script>
    <script src="/static/js/bootstrap.js"></script>
</head>
<body>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-6 column">
			 <a class="btn btn-lg active btn-link" href="/admin/index">后台主页</a>
			 <a class="btn btn-lg active btn-link" href="/">前台主页</a> 
			 <a class="btn btn-lg active btn-link" href="/admin/category/index">类型管理</a>
			 <a class="btn btn-lg active btn-link" href="/admin/product/index">商品管理</a>
		</div>
		<div class="col-md-6 column">
			 <a class="btn btn-lg active btn-link" href="/loginjsp">登陆</a>
			 <a class="btn btn-lg active btn-link" href="/registerjsp">注册</a>
		</div>
	</div>
</div> 

<script>
	/* $("a").click(function(e){
		 e.preventDefault();
	}); */
</script>
</body>
</html>