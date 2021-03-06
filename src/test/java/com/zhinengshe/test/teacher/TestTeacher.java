package com.zhinengshe.test.teacher;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.questionnaire.IQuestionnaireService;
import com.zhinengshe.service.teacher.ITeacherService;
import com.zhinengshe.test.basetest.BaseTest;
import com.zhinengshe.utlis.pagenation.Pagination;

@SuppressWarnings("unchecked")
public class TestTeacher extends BaseTest{
	
	@Resource
	private ITeacherService teacherService;
	
	@Resource
	private IQuestionnaireService questionnaireService;
	
	/**
	 * 添加教师
	 */
	@Test
	public void testAdd() throws Exception{
		Teacher teacher = new Teacher();
		teacher.setName("小明爱吃菜");
		teacher.setCategory(new Byte("1"));
		teacher.setTel("123456789");
		teacher.setUsername("小明不吃肉4");
		teacher.setPassword("xiaomingbuchirou");
		Boolean flag = this.teacherService.add(teacher);
		System.out.println(flag);
		
	}
	
	@Test
	public void testGet() throws Exception{
		Questionnaire questionnaire = questionnaireService.get(1);
		System.out.println(JSON.toJSONString(questionnaire));
		
	}
	
	@Test
	public void testListByPage1() throws Exception{
		
		Pagination pagination = teacherService.list("王",null,null,null,1);
		List<Teacher> list = (List<Teacher>) pagination.getList();
		for (Teacher t : list) {
			System.out.println(JSONObject.toJSONString(t));
		}
	}

	@Test
	public void testListByPage2() throws Exception{
		
		Pagination pagination = teacherService.list(null,null,null,null,null);
		List<Teacher> list = (List<Teacher>) pagination.getList();
		for (Object t : list) {
			System.out.println(JSONObject.toJSONString(t));
		}
	}
	
	@Test
	public void testListByPage3() throws Exception{
		
		Pagination pagination = teacherService.list("王",null,null,null,3);
		List<Teacher> list = (List<Teacher>) pagination.getList();
		for (Teacher t : list) {
			System.out.println(JSONObject.toJSONString(t));
		}
	}
}
