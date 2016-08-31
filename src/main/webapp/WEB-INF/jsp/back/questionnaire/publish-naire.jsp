<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>后台发布页</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/base.css" />
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
	<div class="middle-release">
		<form name="frm">
			<div class="xz">选择问卷</div>
			<ul class="cp clearfix">
				<li>
					<label>
						<input name="cp" type="checkbox" value="" />
							测评
					</label>
				<li>
					<label>
						<input name="cp" type="checkbox" value="" />
							测评
					</label>
				</li>
			</ul>
			<div class="fb">发布范围</div>
			<div class="one">
				<span>1,选择用户</span>
				<input type="text"/>
			</div>
			<ul class="yh">
				<li>
				   <label>
					<input name="cp" type="checkbox" value="" />
						姓名
				   </label>
				</li>
				<li>
				   <label>
					<input name="cp" type="checkbox" value="" />
						姓名
				   </label>
				</li>
				<li>
				   <label>
					<input name="cp" type="checkbox" value="" />
						姓名
				   </label>
				</li>
				<li>
				   <label>
					<input name="cp" type="checkbox" value="" />
						姓名
				   </label>
				</li>
				<li>
				   <label>
					<input name="cp" type="checkbox" value="" />
						姓名
				   </label>
				</li>
				<li>
				   <label>
					<input name="cp" type="checkbox" value="" />
						姓名
				   </label>
				</li>
			</ul>
			<div class="two">
				<span>2,选择班级</span>
				<ul>
					<li>
						<label>
						<input name="cp" type="checkbox" value="" />
							2016-5-13css全日制
						</label>
					</li>
					<li>
						<label>
						<input name="cp" type="checkbox" value="" />
							2016-5-13css全日制
						</label>
					</li>
				</ul>
			<input type="submit" value="发布问卷" class="btn" />
			</div>
		</form>
	</div>
		
	<div class="footer"></div>
</body>
</html>