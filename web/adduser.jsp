<%--
  Created by IntelliJ IDEA.
  User: InJamie
  Date: 2020/3/22
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="js/bootstrap.js"></script>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="js/jquery-3.2.1.min.js"></script>
<head>
    <title>Add User</title>
</head>
<body>
<div style="margin: 50px auto;width: 500px;position: relative">
    <strong style="color: red;display: inline-block;position: absolute;margin: 90px 38px">${img}</strong>
<h1 style="margin-bottom: 50px;">添加新用户</h1>
<form action="${pageContext.request.contextPath}/addServlet" >
    <div class="form-group">
        <label for="exampleInputEmail1">姓名</label>
        <input type="text" class="form-control" id="exampleInputEmail1" name="name">
    </div>
    <div class="form-group">
        <label >性别</label>
        <input type="radio"name="gender" value="男" checked="checked">男
        <input type="radio"name="gender" value="女" >女
    </div>
    <div class="form-group">
        <label>年龄</label>
        <input type="text" class="form-control" name="age">
    </div>
    <div class="form-group">
        <label>住址</label>
        <input type="text" class="form-control" name="address">
    </div>

    <div class="form-group">
        <label>qq</label>
        <input type="text" class="form-control" name="qq">
    </div>

    <div class="form-group">
        <label>邮箱</label>
        <input type="text" class="form-control" name="email">
    </div>
    <button type="reset" class="btn btn-default" >重 置</button>
    <button type="submit" class="btn btn-default"style="margin: 0 80px">添 加</button>
    <a href="${pageContext.request.contextPath}/userlistServlet"><button type="button" class="btn btn-default" href="/list.jsp">返 回</button></a>

</form>
</div>
</body>
</html>
