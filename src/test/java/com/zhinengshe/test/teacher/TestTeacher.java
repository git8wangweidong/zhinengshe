package com.zhinengshe.test.teacher;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.mail.util.QEncoderStream;
import com.zhinengshe.exception.BusinessException;
import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.questionnaire.IQuestionnaireService;
import com.zhinengshe.service.teacher.ITeacherService;
import com.zhinengshe.test.basetest.BaseTest;


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
	public void testGet(){
		Questionnaire questionnaire = questionnaireService.get(1);
		System.out.println(JSON.toJSONString(questionnaire));
		
	}

}
