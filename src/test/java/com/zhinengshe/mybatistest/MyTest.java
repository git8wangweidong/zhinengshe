package com.zhinengshe.mybatistest;

import javax.annotation.Resource;

import org.junit.Test;

import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.teacher.ITeacherService;
import com.zhinengshe.test.basetest.BaseTest;

/**
 * 测试spring-mybatis整合
 * @author Administrator
 *
 */
public class MyTest extends BaseTest{


	//private static Logger logger = Logger.getLogger(MyTest.class);
	
	@Resource
	private ITeacherService teacherService;
	
	@Test
	public void testTeacherService(){
		//Teacher teacher = teacherService.getTeacherById(1);
		
		//System.out.println(JSON.toJSONString(teacher));
		
	}
	
	
	@Test
	public void testInsert(){
		
		Teacher teacher = new Teacher();
		teacher.setId(null);
		teacher.setName("23123");
		teacher.setUsername("123123123");
		teacher.setPassword("123132");
		teacher.setTel("123213123");
		teacher.setCategory(new Byte("1"));
		
		//int i = teacherService.insert(teacher);
		
		//System.out.println(i);
		
	}
	
}
