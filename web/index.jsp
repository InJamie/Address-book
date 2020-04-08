<%--
  Created by IntelliJ IDEA.
  User: InJamie
  Date: 2020/3/18
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>Address book</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  <script src="js/bootstrap.js"></script>
  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="js/jquery-3.2.1.min.js"></script>

  <style>
    #form {
      width: 580px;
      height: 200px;
      margin: 100px auto;
    }
    #img {
      color: red;
      font-size: 20px;
      margin-left: 100px;
    }
  </style>
  <script>

  </script>



</head>
<body>
<h1 style="text-align: center; margin: 50px">
  Address book
</h1>


<form class="form-horizontal" id="form" action="${pageContext.request.contextPath}/loginServlet">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" placeholder="请输入账号" name="user">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码" name="password">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="CheckCode" placeholder="请输入验证码" name="checkcode">
    </div>
    <img style="margin: 10px 120px" src="${pageContext.request.contextPath}/checkCodeServlet" alt="">
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">登录</button>
    </div>
  </div>
  <strong style="color: red">${img}</strong>
</form>

</body>
</html>
