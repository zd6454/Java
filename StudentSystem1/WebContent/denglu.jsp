<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>登录注册页面</title>
</head>
<body>
<div style="position: absolute; top: 60%; left:70%; margin: -300px 0 0 -400px; width: 800px;
               height: 600px; ">
<h3>${zhu}</h3>
     <form action="DengluServlet" method="post" style="padding-top:-700px">
      用户名:<input type="text" name="name" value=""><br><br>
      密码:  <input type="password" name="password" value=""><br><br>
      权限:
    <select name="type">
        <option value="admin" >档案管理员</option>
        <option value="or" >档案录入员</option>
        <option value="reject" >普通档案用户</option>
    </select>
           <input type="submit" value="登录" name="denglu"><input type="reset" value="重置"><br>
     </form>
   </div>
</body>
</html>