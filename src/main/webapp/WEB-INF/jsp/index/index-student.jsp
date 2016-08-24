<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>app测评页</title>
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" href="">
</head>
<body>
	<div class="wamp">
		<!-- 头部 -->
		<div class="top">
			<div>智能社学习在线网</div>
		</div>
		<!-- 描述 -->
		<div class="classus">
			<h4>课程吸收情况统计表</h4>
			<p>本问卷实习匿名制,所有数据只用于统计分析,请放心填写,题目项无对错之分,请您按自己的实际情况填写,谢谢您的帮助</p>
		</div>
		<!-- 课程方面 -->
		<div class="cateclass">
			<h5 class="h5">在这个学习阶段,你认为</h5>
			<form name="frm" method="post" action="/questionnaire/receive">

				<input type="hidden" name="id" value="1" />

				<div class="classbox">
					<!-- 遍历获取题目类型 -->
					<c:forEach items="${naire.questiontypes }" var="types">
						<div class="titile">${types.name }</div>
						<!-- 遍历获取题目 -->
						<c:forEach items="${naire.questions }" var="que" varStatus="vs">
							<!-- 判断题目是否为当前类型 是：显示 否：不显示 -->
							<c:if test="${types.id == que.questiontype}">
								<c:if test="${types.id!=4 }">
									<div class="classkcs getval" id="input_${(vs.count)-1 }">
										<label for="">${que.question }</label>
										<input type="hidden"  name="questions[${(vs.count)-1 }].id" value="${que.id }"/>
										<input type="hidden"  name ="questions[${(vs.count)-1 }].answer" value=""/>
										<input type="hidden"  name ="questions[${(vs.count)-1 }].questiontype" value="${que.questiontype }"/>
										<ul class="ulcont">
											<li>1</li>
											<li>2</li>
											<li>3</li>
											<li>4</li>
											<li>5</li>
											<li>6</li>
											<li>7</li>
											<li>8</li>
											<li>9</li>
											<li>10</li>
										</ul>
									</div>
								</c:if>
								<c:if test="${types.id==4 }">
									<div class="classbox">
										<div class="titile">${que.question }</div>
										<input type="hidden" name="questions[${(vs.count)-1 }].questiontype"
											value="${que.questiontype }" />
										<input type="hidden" name="questions[${(vs.count)-1 }].id"
											value="${que.id }" />
										<div>便于我们帮你复习巩固</div>
										<textarea class="text" style="overflow-y: hidden" name="questions[${(vs.count)-1 }].answer"></textarea>
									</div>
								</c:if>
							</c:if>
						</c:forEach>
					</c:forEach>
					<input type="submit" class="sb" value="提交" />
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		if (window.hasOwnProperty("ontouchstart")) {
			var _event = 'touchend';
		} else {
			var _event = 'click';
		}
		var base = {
			inIt : function() {
				this.bGs();
			},
			bGs : function() {
				var ulli = $(".ulcont  li");
				ulli.on(_event, function() {
					$(this).addClass('libgs').siblings('li').removeClass(
							'libgs');

				})

			}
		}
		base.inIt();

	})
</script>


</html>