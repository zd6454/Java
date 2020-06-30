<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page  isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
 String path=request.getContextPath();
 String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<base href="<%=basePath%>">
<title>查找页面</title>
</head>
<body>
<h1>${zhu}</h1>
<h3 align="center" >${success}</h3>
        <form action="Searchby" method="post" style="padding-top:-700px" align="center">  >
        <select name="num" >
           <option value="">-请选择查询方式-</option>
           <option value="name">姓名</option>
           <option value="sex">性别</option>
           <option value="race">民族</option>
           <option value="duty">职位</option>
         </select>
           <input type="text" name="getone"  placeholder="输入" value="">
           <input type="submit" value="查询" name="query">
        </form>
             <table width="600"  align="center"  cellpadding="0" >
    <tr>
    <th>ID</th>
    <th>姓名</th>
    <th>性别</th>
    <th>民族</th>
    <th>出生日期</th>
    <th>密码</th>
    <th>权限</th>
    <th>职务</th>
    </tr>
    <c:forEach var="U" items="${userAll}" >
    <c:choose>
     <c:when test="${name==U.name}">
     <c:choose>
       <c:when test="${password==U.password}">
      <form action="UpdateServlet" method="post">
         <tr>
           <td><input type="text" value="${U.id}" name="id"> </td>
           <td><input type="text" value="${U.name}" name="name"></td>
	       <td><input type="text" value="${U.sex}" name="sex"></td>
	       <td><input type="text" value="${U.race}" name="race"></td>
	       <td><input type="text" value="${U.birthday}" name="birthday"></td>
	       <td><input type="text" value="${U.password}" name="password"></td>
	       <td><input type="text" value="${U.type}" name="type" readonly="readonly"></td>
	       <td><input type="text" value="${U.duty}" name="duty"></td>
	       <td><input type="submit" value="更新"/>  <a href="Downone?id=${U.id}" >下载</a></td>
	       </tr>
      </form>
       </c:when>
       </c:choose>
     </c:when>
     <c:otherwise>
         <tr>
           <td><input type="text" value="${U.id}" name="id" readonly="readonly"> </td>
           <td><input type="text" value="${U.name}" name="name" readonly="readonly"></td>
	       <td><input type="text" value="${U.sex}" name="sex" readonly="readonly"></td>
	       <td><input type="text" value="${U.race}" name="race" readonly="readonly"></td>
	       <td><input type="text" value="${U.birthday}" name="birthday" readonly="readonly"></td>
	       <td><input type="text" value="${U.password}" name="password" readonly="readonly"></td>
	       <td><input type="text" value="${U.type}" name="type" readonly="readonly"></td>
	       <td><input type="text" value="${U.duty}" name="duty" readonly="readonly"></td>
	       </tr>
	   </c:otherwise>  
	   </c:choose>   
	 </c:forEach>
     </table>
     <div align="center">
     <a  href="Downfile" >下载档案信息</a>
     <h3 align="center" >${zhu2}</h3>
     </div>
</body>
</html>