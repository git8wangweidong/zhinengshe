<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib-my.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>后台添加用户页</title>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/base.css" />
<script type="text/javascript" language="javascript">

	/* 查询  */
	function search() {
		document.teacher.method="get";
		document.teacher.action="/teacher/list";
		document.teacher.submit();
	}
	/* 删除确认  */
	function del(id){
		if(confirm("确定删除本条记录？")){
			window.location.href="/teacher/del?id="+id;
		}
	}
	
</script>


</head>
<body>
	<div class="heade"></div>
	<div class="heade-bottom">
		<ul class="top clearfix">
			<li class="active clearfix">
				<i class="icon1"></i>
				<span>编辑问卷</span>
			</li>
			<li><i class="icon2"></i><span>发布问卷</span></li>
			<li class=""><i class="icon3"></i><span>问卷列表</span></li>
			<li><i class="icon4"></i><span>用户编辑</span></li>
		</ul>
	</div>
	<div class="middle-add">
		<form action="/teacher/add" method="post" name="teacher">
			<div class="top">
				<div class="edit">用户编辑</div>
				<ul class="info clearfix">
					<li class="one"><span>姓名：</span><input type="text" name="name" value="${name }" ></li>
					<li class="two"><span>手机号：</span><input type="text" name="tel" value="${tel }"></li>
					<li class="three"><span>类别：</span><input type="text" name="category" value="${category }"></li>
					<li class="four"><span>用户名：</span><input type="text" name="username" value="${username }"></li>
					<li class="five"><span>密码：</span><input type="text" name="password" value="${password }"></li>
					 <li class="operate">
					 	<input type="submit" value="创建" class="cj"/><input type="button" onclick="search();" class="ss" value="搜索"/>
					 </li>
				</ul>
			</div>
		</form>
		 <table border="0" class="bg" cellspacing="0">
	      <tr class="title">
		        <td>姓名</td>
		        <td>手机</td>
		        <td>班级</td>
		        <td>课程</td>
		        <td>编辑</td>
	      </tr>
	      <c:forEach items="${pagination.list }" var="teacher">
	      	<input  type="hidden" name="id" value="${teacher.id }"/>
		      <tr>
		        <td>${teacher.name }</td>
		        <td>${teacher.category }</td>
		        <td>${teacher. username}</td>
		        <td>${teacher.tel }</td>
		        <td>
			        <a href="/teacher/edit?id=${teacher.id }">修改</a>|
			        <input type="button" onclick="del(${teacher.id });" value="删除">
		        </td>
		      </tr>
	      </c:forEach>
	     </table>
	     <c:forEach items="${pagination.pageView }" var="page">
	     	${page }
	     </c:forEach>
	<div class="footer"></div>
</body>
</html>