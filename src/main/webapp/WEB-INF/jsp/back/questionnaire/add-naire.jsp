<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>后台编辑页</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/base.css" />
</head>
<body>
	<div class="heade"></div>
	<div class="heade-bottom">
		<ul class="top clearfix">
			<li class="active clearfix"><i class="icon1"></i><span>编辑问卷</span></li>
			<li><i class="icon2"></i><span>发布问卷</span></li>
			<li><i class="icon3"></i><span>问卷列表</span></li>
			<li><i class="icon4"></i><span>用户编辑</span></li>
		</ul>
	</div>
	<div class="middle">
		<div class="middle-center">
			<div class="left">
				<ul>
					<li class="activity"><a href="#">常用题型</a></li>
					<li class="L"><a href="">打分题</a></li>
					<li class="L"><a href="">多选题</a></li>
					<li class="L"><a href="">单选题</a></li>
					<li class="L"><a href="">填空题</a></li>
					<li class="L"><a href="">简答题</a></li>
				</ul>
			</div>
			<div class="right">
				<div class="top">
					<span>满意度</span>
					<div class="top-one">
					   <div class="hy">
						欢迎参加本次答题
						</div>
					</div>
				</div>
				<div class="bottom">
					<div class="one">
						<div class="con"></div>
					</div>
					<div class="two">
						<div class="box"></div>
						<span><a href="#">预览问卷</a></span>
						<span class="activity">
							<a href="">创建问卷</a>
						</span>
						
					</div>
				</div>
			</div>
		</div>
	</div>
		
	<div class="footer"></div>
</body>
</html>