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
		<form action="/manager/update" method="post" name="manager">
			<div class="top">
				<div class="edit">用户编辑</div>
				<ul class="info clearfix">
					<li class="one"><span>姓名：</span><input type="text" name="name" value="${manager.name }"></li>
					<li class="two"><span>用户名：</span><input type="text" name="username" value="${manager.username }"></li>
					<li class="three"><span>密码：</span><input type="text" name="password" value="${manager.password }"></li>
					 <li class="operate">
					 <input type="hidden" name="id" value="${manager.id }">
					 	<input type="submit" value="修改" class="cj"/>
					 	<input type="reset" value="还原" class="ss"/>
					 </li>
				</ul>
			</div>
		</form>
		<br />
		<br />
	<div class="heade-bottom"></div>
	<div class="footer"></div>
</body>
</html>