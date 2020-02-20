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

</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <p>
                <a href="/">继续购物</a>
            </p>
            <form method="post">
                <button value="删除"  id="batchDelete" class="btn btn-primary btn-danger">删除</button>
            </form>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th><input type="checkbox" id="batchDeleteChecked"></th>
                    <th>
                        名称
                    </th>
                    <th>
                        单价
                    </th>
                    <th>
                        数量
                    </th>
                    <th>
                        小计
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cart.items}" var="item">
                    <form method="post" action="/removefromcart">
                        <input type="hidden" name="pid" id="pid" value="${item.productEntity.pid}"/>

                        <tr>
                            <td><input type="checkbox" ></td>
                            <td>${item.productEntity.pname}</td>
                            <td>${item.productEntity.unitprice}</td>
                            <td><input type="tel" name="qty" id="qty" value="${item.qty}"/></td>
                            <td>${item.subTotal}</td>
                            <td><input type="button" value="删除" class="btn btn-primary btn-danger"></td>
                        </tr>
                        <input type="submit" value="提交" style="display:none " />
                    </form>
                </c:forEach>
                <tr ><td colspan="6" style="align-content: right ">总计: ${cart.total}</td> </tr>
                </tbody>


            </table>
        </div>
    </div>
</div>

<script>
    $(function () {
        $("#batchDeleteChecked").click(function () {
            $("tbody :checkbox").prop("checked", $(this).prop("checked"));
        });

        //批量删除
        $("#batchDelete").click(function () {

            var url= "/removefromcart?";
            $("tbody :checkbox").each(function (index,ele) {
                if($(ele).prop("checked")){
                    url += ("pid=" + $(ele).closest("tr").find("td:eq(1)").text());
                    url += "&";
                }
            });
            url = url.substring(0, url.length - 1);

            var $form = $(this).parent();//<form>
            $form.prop("action", url);
            alert($form.prop("action"));
            $form[0].submit();

        });
        //删除
        $("input[value='删除']")
        /* 控制商品数量，做到实时提交 */
        $("input[type='tel']").change(function(){
        	
        	
        });
        

    })
</script>
</body>
</html>
