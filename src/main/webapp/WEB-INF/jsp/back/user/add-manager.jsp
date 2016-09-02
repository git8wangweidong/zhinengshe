<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib-my.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!doctype html>
<html>
<head>
<meta charset="utf-8">
	<title>后台添加用户页</title>
	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/css/base.css" />
	<script type="text/javascript" language="javascript">

	/* 查询  */
	function find() {
		document.manager.method="get";
		document.manager.action="/manager/list";
		document.manager.submit();
	}
	/* 删除确认  */
	function del(id){
		if(confirm("确定删除本条记录？")){
			window.location.href="/manager/del?id="+id;
		}
	}
	/* 修改 */
	function edit(id){
			window.location.href="/manager/edit?id="+id;
	}
	
</script>
</head>
<body>
	<div class="heade"></div>
	<div class="heade-bottom">
		<ul class="top clearfix">
			<li class="active clearfix"><i class="icon1"></i> <span>编辑问卷</span>
			</li>
			<li><i class="icon2"></i><span>发布问卷</span></li>
			<li class=""><i class="icon3"></i><span>问卷列表</span></li>
			<li><i class="icon4"></i><span>用户编辑</span></li>
		</ul>
	</div>
	<div class="middle-add">
		<form action="/manager/add" method="post" name="manager">
			<div class="top">
				<div class="edit">用户编辑</div>
				<ul class="info clearfix">
					<li class="one"><span>姓名：</span><input type="text" name="name"></li>
					<li class="two"><span>用户名：</span><input type="text"
						name="username"></li>
					<li class="three"><span>密码：</span><input type="text"
						name="password"></li>
					<li class="operate"><input type="submit" value="创建" class="cj" /><input
						type="button" onclick="find();" class="ss" value="搜索" /></li>
				</ul>
			</div>
		</form>
		<table border="0" class="bg" cellspacing="0">
			<tr class="title">
				<td>姓名</td>
				<td>用户名</td>
				<td>操作</td>
			</tr>
			<c:if test="${!empty pagination }">
				<c:forEach items="${pagination.list }" var="manager">
					<input type="hidden" name="id" value="${manager.id }" />
					<tr>
						<td>${manager.name }</td>
						<td>${manager. username}</td>
						<td>
							<input type="button" onclick="edit(${manager.id })"value="修改">| 
							<input type="button" onclick="del(${manager.id });" value="删除">
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<!-- 分页页码展示 -->
		</table>
		<c:if test="${!empty pagination }">
			<c:forEach items="${pagination.pageView }" var="page">
		     	${page }
		     </c:forEach>
		</c:if>
		<div class="footer"></div>
</body>
</html>