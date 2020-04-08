<%--
  Created by IntelliJ IDEA.
  User: InJamie
  Date: 2020/3/22
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>引导页面</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        function deleteUser(id){
            if (confirm("您确定要删除嘛？")){
                location.href="${pageContext.request.contextPath}/deleteServlet?id="+id;
            }
        }
        window.onload = function(){
            /**
             * 删除选中用户  将表格看作一个表单 给checked赋值id 相当于checked的id才会提交
             */
            document.getElementById("delbtn").onclick = function(){
                if (confirm("你确定要删除所选吗")){
                    var Flag = false
                    var cbs = document.getElementsByName("ucb");
                    for (var i = 0; i < cbs.length ; i++) {
                        if (cbs[i].checked){
                            Flag =true;
                            break;
                        }
                    }
                    if (Flag){
                        document.getElementById("form").submit();
                    }
                }
            }
            /**
             * 全选按钮
             */
            document.getElementById("firstCb").onclick = function () {
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("ucb");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;

                }
            }
        }

    </script>

    <title>List</title>
</head>
<body>
<div style="margin: 10px auto;width: 1000px">
<h1 style="text-align: center">用户列表</h1>
<form class="form-inline" style="margin: 10px 10px; display: inline-block">
    <div class="form-group">
        <label for="exampleInputName2">姓名</label>
        <input type="text" class="form-control" id="exampleInputName2" placeholder="姓名">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail2">邮箱</label>
        <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
    </div>
    <div class="form-group">
        <label for="exampleInputName2">籍贯</label>
        <input type="text" class="form-control" placeholder="籍贯">
    </div>
    <button type="submit" class="btn btn-default">查询</button>
</form>
    <a href="adduser.jsp"><input class="btn btn-default" type="button" value="添加联系人"></a>
    <a href="javascript:void(0)"><input class="btn btn-default" type="button" value="删除所选"  id="delbtn"></a>
    <form action="${pageContext.request.contextPath}/deletecheckedServlet"  id="form" method="post">
<table class="table table-striped" style="margin:30px 0">
    <tr>
        <th><input type="checkbox" id="firstCb"></th>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>住址</th>
        <th>qq</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${userlist}" var="user" varStatus="s">
        <tr>
            <td><input type="checkbox" name="ucb" value="${user.id}"></td>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td>
                <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/finduserServlet?id=${user.id};">修改</a>
                <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a>
            </td>


        </tr>
    </c:forEach>

</table>
    </form>
</div>
</body>
</html>
