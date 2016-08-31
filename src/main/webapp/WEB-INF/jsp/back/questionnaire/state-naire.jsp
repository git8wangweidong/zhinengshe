<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>后台列表页</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/base.css" />
</head>
<body>
	<div class="heade"></div>
	<div class="heade-bottom">
		<ul class="top clearfix">
			<li class="clearfix">
				<i class="icon1"></i>
				<span>编辑问卷</span>
			</li>
			<li><i class="icon2"></i><span>发布问卷</span></li>
			<li class="active"><i class="icon3"></i><span>问卷列表</span></li>
			<li><i class="icon4"></i><span>用户编辑</span></li>
		</ul>
	</div>
	<div class="middle-list">
		<ul class="top">
			<li>
				<div class="title">名称</div>
				<div class="da">智能社</div>
			</li>
			<li>
				<div class="title">发布时间</div>
				<div class="da">2016-5-5</div>
			</li>
			<li>
				<div class="title">发布人数</div>
				<div class="da dA">6</div>
			</li>
			<li>
				<div class="title">已作答人数</div>
				<div class="da dA">6</div>
			</li>
			<li class="last">
				<div class="title">完成率</div>
				<div class="da dA">100%</div>
			</li>
		</ul>
		 <table border="0" class="bg" cellspacing="0">
	      <tr class="title">
		        <td>序号</td>
		        <td>姓名</td>
		        <td class="time">开始时间</td>
		        <td>用时</td>
		        <td>查看操作</td>
	      </tr>
	      <tr>
		      	<td>1</td>
		        <td>张三</td>
		        <td class="time">2016-07-04 19:59:07</td>
		        <td>0分1秒</td>
		        <td>查看</td>
	      </tr>
	       <tr>
		      	<td>2</td>
		        <td>张三</td>
		        <td>2016-07-04 19:59:07</td>
		        <td>0分1秒</td>
		        <td>查看</td>
	      </tr>
	       <tr>
		      	<td>3</td>
		        <td>张三</td>
		        <td>2016-07-04 19:59:07</td>
		        <td>0分1秒</td>
		        <td>查看</td>
	      </tr>
	       <tr>
		      	<td>4</td>
		        <td>张三</td>
		        <td>2016-07-04 19:59:07</td>
		        <td>0分1秒</td>
		        <td>查看</td>
	      </tr>
	       <tr>
		      	<td>5</td>
		        <td>张三</td>
		        <td>2016-07-04 19:59:07</td>
		        <td>0分1秒</td>
		        <td>查看</td>
	      </tr>
	       <tr>
		      	<td>6</td>
		        <td>张三</td>
		        <td>2016-07-04 19:59:07</td>
		        <td>0分1秒</td>
		        <td>查看</td>
	      </tr>
	     </table>

	</div>
		
	<div class="footer"></div>
</body>
</html>