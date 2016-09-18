<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<title>问卷展示页</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/naire/base.css" />
<link rel='stylesheet'
	href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
<link rel='stylesheet prefetch'
	href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/naire/style.css" media="screen"
	type="text/css" />
<script
	src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
<script
	src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
<link href="<%=request.getContextPath()%>/css/naire/public_v2.css"
	rel="stylesheet">

<link href="<%=request.getContextPath()%>/css/naire/public_v2.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/naire/style_v2.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/naire/button.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/naire/popuplayer_v2.css"
	rel="stylesheet">
<!-- <link href="<%=request.getContextPath()%>/css/naire/edit_cq.css" id="css_url" rel="stylesheet"> -->
<style type="text/css">
.q_title {
	
}

.T_edit_min, .T_edit_td {
	
}

.p_title {
	
}

.p_begin_desc {
	
}

.p_end_desc {
	
}
</style>

<!--script src="/static/js/jquery.js?v=b8e88e87301643b74f0df01461582202"></script-->
<script charset="utf-8"
	src="<%=request.getContextPath()%>/js/naire/v.js"></script>
<script src="<%=request.getContextPath()%>/js/naire/hm.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/naire/jquery_1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/naire/jquery-migrate-1.2.1.js"></script>
<script src="<%=request.getContextPath()%>/js/naire/jquery.cookie.js"></script>
<script
	src="<%=request.getContextPath()%>/js/naire/jquery-ui-1.10.min.js"></script>
<script src="<%=request.getContextPath()%>/js/naire/json.js"></script>
<script src="<%=request.getContextPath()%>/js/naire/base_utils.js"></script>

<link href="<%=request.getContextPath()%>/css/naire/paid.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/naire/paid.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/naire/base_utils.js"></script>
<style>
.cke {
	visibility: hidden;
}
</style>
<script type="text/javascript">
	$(function(){
		$(".top li span").click(function(){
			// alert(1);
		});
	})
	
	// 提交问卷
	function naire_submit(){
		document.getElementById("form_naire").submit();
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
	<div class="all-content">
		<form role="form">
			<!-- 58-94-6B-38-11-94 -->
		</form>
		<div class="wjContent">
			<!--wentop-->
			<div class="wentop wentop_cq">
				<ul id="myTab" class="nav1 nav2-tabs">
					<li><a
						href="https://www.XXX.com/s/veuui25?test=1&amp;v=0.290907120062"
						target="_blank"> <i class="design-set4-icon"></i> 预览问卷
					</a></li>
					<li class="release_cq"><a target="_blank"
						onclick="javascript:naire_submit();">
							<i class="design-set5-icon"></i> 发布问卷
					</a></li>
				</ul>
				<h4 class="h4st1">
					<div class="h4Title">0826</div>
				</h4>
				<div id="myTabContent" class="tab2-content">
					<div class="tab-pane fade in active" id="design">
						<ul class="fr">
							<li class="design-set-li"><a id="appearset"
								href="javascript:;"> <i class="design-set1-icon active"></i>
									<!--b></b-->外观设置
							</a></li>
							<li><a class="logicset" href="javascript:;"> <i
									class="design-set2-icon"></i>逻辑设置
							</a> <a
								href="http://www.wenjuan.com/helpcenter/list/53916b15f7405b30051f15b8/h355d1b18bf7405b23db06d18a"
								target="_blank" class="lj_tip"></a></li>
						</ul>
					</div>
					<div class="tab-pane fade" id="collect">
						<ul class="fr">
							<li><a href="javascript:;"> <i
									class="collect-set1-icon active"></i> 问卷链接
							</a></li>
							<li><a href="javascript:;"> <i class="collect-set2-icon"></i>
									社交分享
							</a></li>
							<li><a href="javascript:;"> <i class="collect-set3-icon"></i>
									邮件邀请
							</a></li>
							<li><a href="javascript:;"> <i class="collect-set4-icon"></i>
									网站收集
							</a></li>
						</ul>
					</div>
					<div class="tab-pane fade" id="analyse">
						<ul class="fr">
							<li><a href="javascript:;"> <i
									class="analyse-set1-icon active"></i> 基本图表
							</a></li>
							<li><a href="javascript:;"> <i class="analyse-set2-icon"></i>
									交叉图表
							</a></li>
							<li><a href="javascript:;"> <i class="analyse-set3-icon"></i>
									答卷详情
							</a></li>
						</ul>
					</div>
				</div>
				<!--/.tab2-content-->
			</div>
			<!--/.wentop-->
			<div class="cq_content clear" style="min-height: 500px;">
				<div class="row-fluid clear">
					<div class="rows1" style="">
						<div class="well sidebar-nav affix-top" id="accordion1">
							<div class="accordion-group">
								<h4 class="tc">
									<a href="javascript:;"> 常用题型 <i class="icon_on"></i>
									</a>
								</h4>
								<ul class="ul-tool collapse">
									<li class="moduleL ui-draggable" name="2"><a
										href="javascript:;"> <i class="basic-too11-icon-active"></i>
											单选题
									</a></li>
									<li class="moduleL ui-draggable" name="3"><a
										href="javascript:;"> <i class="basic-too12-icon-active"></i>
											多选题
									</a></li>
									<li class="moduleL ui-draggable" name="2"
										disp_type="image_single"><a href="javascript:;"> <i
											class="basic-too2014-icon-active"></i> 图片选择题
									</a></li>
									<li class="moduleL ui-draggable" name="6"><a
										href="javascript:;"> <i class="basic-too13-icon-active"></i>
											单行填空题
									</a></li>
									<li class="moduleL ui-draggable" name="6"
										disp_type="multi_line_blank"><a href="javascript:;">
											<i class="basic-too200-icon-active"></i> 多行填空题
									</a></li>
									<li class="moduleL ui-draggable" name="95"><a
										href="javascript:;"> <i class="basic-too16-icon-active"></i>
											多项填空题
									</a></li>
									<li class="moduleL ui-draggable" name="60"><a
										href="javascript:;"> <i class="basic-too15-icon-active"></i>
											排序题
									</a></li>
									<li class="moduleL ui-draggable" name="50"><a
										href="javascript:;"> <i class="basic-too14-icon-active"></i>
											打分题
									</a></li>
									<li class="moduleL ui-draggable" name="2"
										disp_type="font_vote_single"><a href="javascript:;">
											<i class="basic-too114-icon-active"></i> 文字投票题
									</a></li>
									<li class="moduleL ui-draggable" name="3"
										disp_type="image_vote_single"><a href="javascript:;">
											<i class="basic-too115-icon-active"></i> 图片投票题
									</a></li>
									<li class="moduleL ui-draggable" name="4"><a
										href="javascript:;"> <i class="basic-too18-icon-active"></i>
											矩阵选择题
									</a></li>
									<li class="moduleL ui-draggable" name="70"><a
										href="javascript:;"> <i class="basic-too111-icon-active"></i>
											描述说明
									</a></li>
									<li class="moduleL ui-draggable" name="3"
										disp_type="upload_file"><a href="javascript:;"> <i
											class="basic-too2015-icon-active"></i> 上传题
									</a></li>

									<li class="moduleL ui-draggable" name="50"
										disp_type="nps_score"><a href="javascript:;"> <i
											class="basic-too113-icon-active"></i> NPS题 <i
											class="basic-lock-icon-active lock_nps_score"></i>
									</a></li>

									<li class="moduleL ui-draggable" name="page"><a
										href="javascript:;"> <i class="basic-too112-icon-active"></i>
											分页
									</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!--/.rows1-->
					<div class="jt"></div>
					<div class="right_operate">
						<a href="javascript:;" class="close"></a>
						<h4 class="bt">题目设置</h4>
						<div class="operate_nr">
							<div class="setup"></div>
							<div class="btn_a">
								<p>
									<a href="javascript:;" class="lj_btn">逻辑设置</a><a
										href="http://www.wenjuan.com/helpcenter/list/53916b15f7405b30051f15b8/h355d1b18bf7405b23db06d18a"
										target="_blank" class="lj_tip2"></a>
								</p>
								<p>
									<a href="javascript:;" class="yy_btn">引用设置</a><a
										href="http://www.wenjuan.com/helpcenter/list/53916b3ef7405b300a4902b9/h356826ceda320fc2290b60aa0"
										target="_blank" class="yy_tip"></a>
								</p>
							</div>
							<div class="btn">
								<a href="javascript:;" class="save">保存</a>
								<!-- <a href="javascript:;" class="reset">取消</a> -->
							</div>
						</div>
					</div>
					<form action="questionnaire/toPublic" method="post" id="form_naire">
						<!-- right_operate -->
						<div class="rows2 well2 Tj" style="min-height: 500px;">
							<div class="cq_title">
								<h4 name="project" class="h4-bg T_edit p_title">
									<p style="text-align: center;">0826</p>
								</h4>
							</div>
							<table class="table1 bg-m">
								<tbody>
									<tr>
										<td class="rb">&nbsp;</td>
										<td>
											<div class="th4 T_edit p_begin_desc" name="begin_desc">欢迎参加本次答题</div>
										</td>
									</tr>
								</tbody>
							</table>
							<ul class="dragwen ui-sortable" id="question_box"
								style="background: none;">
								<!-- 题目的html放这里 -->
								<li class="module question" oid="57ce222da320fc4ae50e55bf"
									issue="2" disp_type="vertical" cols_count="1">
									<div class="topic_type">
										<div class="topic_type_menu">
											<div class="setup-group">
												<h4>Q1</h4>
												<a class="up_cq" href="javascript:;" style="display: none;">
													<i class="up-icon-active"></i>
												</a> <a class="down_cq" href="javascript:;"
													style="display: none;"> <i class="down-icon-active"></i>
												</a> <a class="Bub" href="javascript:;" style="display: none;">
													<i class="copy-icon-active"></i>
												</a> <a class="Del" href="javascript:;" style="display: none;">
													<i class="del2-icon-active"></i>
												</a>
											</div>
										</div>
										<div class="topic_type_con">
											<div class="Drag_area">
												<div class="th4 T_edit q_title" name="question">单选题</div>
											</div>
											<ul class="unstyled ">
												<li style=""><input type="radio" name="radio"
													id="option_57ce222da320fc4ae50e55c0"
													value="option_57ce222da320fc4ae50e55c0"><label
													class="T_edit_min" for="" name="option"
													id="57ce222da320fc4ae50e55c0">选项1</label></li>
												<li style=""><input type="radio" name="radio"
													id="option_57ce222da320fc4ae50e55c1"
													value="option_57ce222da320fc4ae50e55c1"><label
													class="T_edit_min" for="" name="option"
													id="57ce222da320fc4ae50e55c1">选项2</label></li>
											</ul>
											<div class="operationH">
												<a href="javascript:;" class="cq_add" style="display: none;">
													<i class="add-icon-active"></i>
												</a> <a class="Bub" href="javascript:;" style="display: none;">
													<i class="clone-icon-active"></i>
												</a>
											</div>
										</div>
									</div>
								</li>
							</ul>
					</form>
					<ul class="ul_tail">
						<li class="module paging" oid="|">
							<div class="topic_type">
								<div class="topic_type_menu">
									<div class="setup-group">
										<a class="DelPaging" href="javascript:;"> <i
											class="del2-icon-active"></i>
										</a>
									</div>
								</div>
								<div class="topic_type_con">
									<div class="icon_paging"></div>
									<div class="fr con_paging">
										页码： <span>1/1</span>
									</div>
								</div>
							</div>
						</li>
					</ul>

					<table class="table1 bg-m">
						<tbody>
							<tr>
								<td class="rb"></td>
								<td>
									<div class="selectEnd">
										<select id="end_desc_type">
											<option value="complete">正常完成</option>
											<option value="screenout">提前结束（不计入结果）</option>
										</select> <span> 时显示</span>
									</div>
									<h4 name="end_desc" class="th4 T_edit p_end_desc" id="end_desc">

										<p style="text-align: center;">您已完成本次问卷，感谢您的帮助与支持</p>

									</h4>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!--/.row-fluid-->
			</div>
			<!--/container-fluid-->
		</div>
		<form id="change_project_status_form"
			action="https://www.wenjuan.com/edit/ajax/update_project_status/"
			method="POST" callback="change_project_status_callback">
			<input type="hidden" name="proj_id"> <input type="hidden"
				name="status"> <input type="hidden" name="is_shared"><input
				type="hidden" name="_xsrf" value="f736e3e243ee4e07af197fdf19f3e1de">
		</form>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/cq_edit.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/common.js"></script>
		<!--日期组件-->
		<link type="text/css" rel="stylesheet"
			href="<%=request.getContextPath()%>/css/naire/zebra_datepicker_metallic.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/zebra_datepicker.js"></script>
		<!--应用购买-->
		<script src="<%=request.getContextPath()%>/js/naire/tools.js"></script>
		<link href="<%=request.getContextPath()%>/css/naire/common.css"
			rel="stylesheet">
		<script src="<%=request.getContextPath()%>/js/naire/plugin_center.js"></script>
		<script type="text/javascript">　
var project = {"last_updated": {"$date": 1472230562238}, "page_count": 1, "activated": {"$date": 1472229992063}, "share_status": 1, "official_status": 0, "begin_desc": "\u6b22\u8fce\u53c2\u52a0\u672c\u6b21\u7b54\u9898", "short_id": "veuui25", "is_struct_change": 1, "questionpage_id_list": ["57bfbbaaa320fca31c266b2c"], "project_func_id": "51dd234e9b9fbe6646bf4dcf", "questionpage_list": [{"updated": {"$date": 1472212010869}, "_id": {"$oid": "57bfbbaaa320fca31c266b2c"}, "question_id_list": ["57ce222da320fc4ae50e55bf"], "question_list": [{"has_open_option": false, "_id": {"$oid": "57ce222da320fc4ae50e55bf"}, "jumpconstraint_id_list": [], "option_id_list": ["57ce222da320fc4ae50e55c0", "57ce222da320fc4ae50e55c1"], "cid": "Q1", "questionpage_id": "57bfbbaaa320fca31c266b2c", "title": "\u5355\u9009\u9898", "updated": {"$date": 1473155757231}, "matrixrow_list": [], "matrixrow_id_list": [], "option_list": [{"updated": {"$date": 1473155757333}, "cid": "A1", "title": "\u9009\u98791", "is_open": false, "_id": {"$oid": "57ce222da320fc4ae50e55c0"}, "custom_attr": {}, "question_id": "57ce222da320fc4ae50e55bf"}, {"updated": {"$date": 1473155757391}, "cid": "A2", "title": "\u9009\u98792", "is_open": false, "_id": {"$oid": "57ce222da320fc4ae50e55c1"}, "custom_attr": {}, "question_id": "57ce222da320fc4ae50e55bf"}], "question_type": 2, "project_id": "57bfbbaaa320fca31c266b2b", "displayconstraint_id_list": [], "custom_attr": {}}], "project_id": "57bfbbaaa320fca31c266b2b", "custom_attr": {}}], "version": 1, "question_count": 1, "end_desc": "<p style=\"text-align: center;\">\u60a8\u5df2\u5b8c\u6210\u672c\u6b21\u95ee\u5377\uff0c\u611f\u8c22\u60a8\u7684\u5e2e\u52a9\u4e0e\u652f\u6301</p>", "status": 0, "updated": {"$date": 1473156511480}, "first_create_for_member": false, "custom_attr": {"survey_share_pic_url":"<%=request.getContextPath()%>/image/naire/rspd_share_wenjuan.png", "panelsite": "101", "theme": "darkblue", "scrollbar": "on", "new_custom_style": {"TerminalStyle": {"PC": {"R_BgColor": "", "BgImagePosition": "", "backgroundRepeat": "repeat", "ImageURl": "", "BgColor": "#efefef", "WjBgColor": "#fff", "BgImageURl": "", "font": [{"bold": "", "color": "", "underline": "", "italic": "", "font": "", "id": "QuesitonStyle", "size": ""}, {"bold": "", "color": "", "underline": "", "italic": "", "font": "", "id": "OptionsStyle", "size": ""}, {"bold": "", "color": "", "underline": "", "italic": "", "font": "", "id": "TopicStyle", "size": ""}, {"bold": "", "color": "", "underline": "", "italic": "", "font": "", "id": "WelcomeStyle", "size": ""}, {"bold": "", "color": "", "underline": "", "italic": "", "font": "", "id": "EndStyle", "size": ""}], "OtherColor": "#53a4f4", "R_OtherColor": "#fff"}, "Phone": {"TopBgColor": "#53a4f4", "BgColor": "#ffffff", "theme": "7", "R_TopBgColor": "#ffffff", "font": [{"bold": "", "color": "", "underline": "", "italic": "", "font": "", "id": "QuesitonStylePhone", "size": ""}, {"bold": "", "color": "", "underline": "", "italic": "", "font": "", "id": "OptionsStylePhone", "size": ""}, {"bold": "", "color": "", "underline": "", "italic": "", "font": "", "id": "RemarkStylePhone", "size": ""}], "OtherColor": "#53a4f4", "R_OtherColor": "#ffffff"}}, "Language": "zh_CN", "Number": "false", "ProgressBar": "true", "logoPosition": "left", "logoURL": ""}, "screenout_desc": "\u4e0d\u597d\u610f\u601d\uff0c\u60a8\u4e0d\u592a\u9002\u5408\u672c\u6b21\u8c03\u67e5\uff0c\u8c22\u8c22\u60a8\u7684\u65f6\u95f4"}, "is_shared": false, "created": {"$date": 1472212010804}, "title": "<p style=\"text-align: center;\">0826</p>", "creator_id": "57ba513ea320fc3686c15378", "_id": {"$oid": "57bfbbaaa320fca31c266b2b"}, "is_hdgc": false};　
$(function(){
fallback();
$('#wjContent_close, #wjContent_closeT').click(function(){
$('.wjContent_tc').hide()
})
// $("div:not(.p_begin_desc)").click(function(){
// $(backspace).keypress(function(){
// $('.wjContent_tc').css('display','block');
// })
// });
idyC.hoverTip($('.lj_tip'), {
text:'点击查看帮助',
dir:'left',
offsetX:-12,
offsetY:26
});
idyC.hoverTip($('.lj_tip2,.yy_tip'), {
text:'点击查看帮助'
});
$('#lightBox').remove();
// loadMack({off:'on',Limg:0,text:'加载中...',set:0});
$('.logicset').click(function(){
ajax_loads(944,256,'逻辑设置','/edit/ajax/logic_set/57bfbbaaa320fca31c266b2b/?v=' + new Date().getTime());
});
$('#appearset').click(function(){
location.href = '/edit/appearset/57bfbbaaa320fca31c266b2b/?v=' + new Date().getTime();
//mapsets(918,600,'外观设置','/edit/appearset/57bfbbaaa320fca31c266b2b/?v=' + new Date().getTime());
});
$('#ansrest').click(function(){
ajax_loads(640,380,'收集设置','/edit/ansrest/57bfbbaaa320fca31c266b2b/?pre_page=design&v=' + new Date().getTime());
});
var new_rspd_count = 0;
if(new_rspd_count > 0)
{
jsAlert({content:"<p style='text-align:left;'>您的问卷已收集0份数据，修改问卷可能影响收集到的数据。如需修改问卷请至问卷列表页，请点击编辑按钮。</p>", obj: function(){
window.location.href = "/mysurvey";
}});
}
$().Tjj('.fast_machine a',{'widthType':false,'Top':2});
loadMack({off:'off'});
});
function ajax_loads(w,h,title,url){
var wbs = new jsbox({
onlyid:"maptss",
title:title,
conw:w,
//conh:h,
FixedTop:170,
loads:true,
url:url,
range:false,
mack:true
}).show();
}
//弹出框打包配置
function mapsets(w,h,title,url){
var wbs = new jsbox({
onlyid:"maptss",
title:title,
conw:w,
conh:h,
FixedTop:170,
iframe:true,
url:url,
range:false,
mack:true
}).show();
}
function ajax_loads(w,h,title,url){
var wbs = new jsbox({
onlyid:"maptss",
title:title,
conw:w,
//conh:h,
FixedTop:170,
loads:true,
url:url,
range:false,
mack:true
}).show();
}
function close_pop_window(){
$("#maptss").remove();
$('#lightBox').remove();
}
function flush_after_close_window(){
$("#maptss").remove();
$('#lightBox').remove();
window.location.href = "/edit/survey/57bfbbaaa320fca31c266b2b/";
}
function publish_proj_confirm(){
$(".question").each(function(){
verify_question_option.hide($(this).attr("oid"));
})
$.ajax({
url: '/edit/ajax/publish_check/'+get_oid(project)+'/',
dataType: 'JSON',
success: function(ret){
if (ret.invalid_qid_list.length === 0){
var confirm_popup_win = Object();
confirm_popup_win.title = "确认发布";
var content = "是否发布问卷?";
if(project.share_status == 0 && (project.copy_from_pid==undefined||project.copy_from_pid==null||project.copy_from_pid=='')){
var shareUnChecked = localStorage.getItem('share_unchecked_' + get_oid(project));
if (shareUnChecked)
content += "<br><label><input style='vertical-align:middle;margin-left:0px!important;' type='checkbox' id='checkbox_selector'/>共享到模板库</label><i class='tips' title='选中该选项，本问卷经审核合格后会添加到模板库中，供其他会员制作问卷时参考。'></i>";
else
content += "<br><label><input style='vertical-align:middle;margin-left:0px!important;' type='checkbox' checked='checked' id='checkbox_selector'/>共享到模板库</label><i class='tips' title='选中该选项，本问卷经审核合格后会添加到模板库中，供其他会员制作问卷时参考。'></i>";
}
confirm_popup_win.content = content;
confirm_popup_win.obj = publish_proj;
confirm_popup_win.close_obj = cancle_publish_proj;
jsConfirm(confirm_popup_win);
}else{
for (var i = 0; i < ret.invalid_qid_list.length; i++) {
var qid = ret.invalid_qid_list[i];
var qmodel = get_qmodel(qid);
qmodel.show_edit_error_msg();
};
scroll_to($(".question[oid="+ret.invalid_qid_list[0]+"]"));
}
}
})
}
function publish_proj(){
var proj_id = project._id.$oid;
if (!$("#checkbox_selector").attr("checked"))
localStorage.setItem('share_unchecked_' + proj_id, true);
else
localStorage.removeItem('share_unchecked_' + proj_id);
$("#change_project_status_form input[name='proj_id']").val(proj_id);
$("#change_project_status_form input[name='status']").val(1);
$("#change_project_status_form input[name='is_shared']").val($("#checkbox_selector").attr("checked"));
loadMack({off:'on',text:'发布中',set:10000});
ajaxSubmit($("#change_project_status_form"));
}
function change_project_status_callback(info){
setTimeout(function(){

var url = "/collect/urllink/57bfbbaaa320fca31c266b2b/?fp="+info.first_publish;
location.href = url;

}, 3000);
}
function cancle_publish_proj(){
}
var client_uuid = "2e3570f2-73f6-11e6-b40e-44a8420c559c";
//矩阵题宽度调整保存回调
function matrixWidth_callback(qid,col_width_array,new_question){
var table_width =0;
var objPadding = 0;
update_question(new_question);
$("li[oid='"+qid+"'] .table tbody tr").each(function(m){
table_width =0;
$(this).children("td").each(function(i){
objPadding=parseFloat($(this).css('paddingLeft'))+parseFloat($(this).css('paddingRight'))+1;
if(col_width_array[i]==undefined){col_width_array[i]=col_width_array[i-1]};
$(this).width(col_width_array[i]+"px");
if(m>0&&i>0){
if($(this).children(".div").length>0){
$(this).find(".div").width(col_width_array[i]+"px");
}else{
$(this).wrapInner('<div class="div" style="width:'+(col_width_array[i])+'px"></div>');
}
}
table_width+=col_width_array[i]+objPadding;
});
});
$("li[oid='"+qid+"'] .table").width(table_width);
$(".jsbox_close").click();
}
</script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/init.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/public.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/modernizr.custom.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/enums.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/models.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/juicer.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/survey_utils.js"></script>
		<!--加载提示-->
		<link type="text/css" rel="stylesheet"
			href="<%=request.getContextPath()%>/css/naire/load.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/load.js"></script>
		<!--气泡弹框-->
		<link type="text/css" rel="stylesheet"
			href="<%=request.getContextPath()%>/css/naire/JsBubble.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/JsBubble.js"></script>
		<!--弹出框-->
		<link type="text/css" rel="stylesheet"
			href="<%=request.getContextPath()%>/css/naire/jsbox.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/jsbox.js"></script>
		<!--汽包弹出框-->
		<link type="text/css" rel="stylesheet"
			href="<%=request.getContextPath()%>/css/naire/Tjj.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/jquery.zn.js"></script>
		<!--FCK编辑器-->
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/ckeditor.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/edit.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/edit_utils.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/edit_init.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/q_template.js"></script>
		<script src="<%=request.getContextPath()%>/js/naire/ssq.js"></script>
		<script type="text/javascript">
var active_index = 0;
var found = 0;
$(".main-nav li a").each(function(){
if($(this).text() == '问卷')
found = 1;
if(found == 0)
active_index += 1;
});
set_active_head_v2(active_index);
var first_edit = false;
if (first_edit){
//新手帮助
//Help_up();
}
// window.onbeforeunload = function(){
// syncPost('/edit/ajax/exit_edit/'+get_oid(project)+"/", {});
// }
function unlock_nps(){
maptss("解锁题型",'/edit/ajax/unlock_qtype/?qid=' + $(this).attr('qid') + '&disp_type=nps_score&ts=' + (new Date()).getTime(),'740');
return false;
}
$(function(){

})
</script>
		<!--图片裁剪-->
		<link type="text/css" rel="stylesheet"
			href="<%=request.getContextPath()%>/css/naire/Jcrop.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/Jcrop.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/demo.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/naire/dmuploader.min.js"></script>

	</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/naire/index.js"></script>
	<div class="footer"></div>
</body>

</html>