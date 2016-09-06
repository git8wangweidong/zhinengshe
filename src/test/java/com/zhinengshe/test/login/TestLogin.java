package com.zhinengshe.test.login;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.login.IManagerLoginService;
import com.zhinengshe.service.login.IStudentLoginService;
import com.zhinengshe.service.login.ITeacherLoginService;
import com.zhinengshe.test.basetest.BaseTest;

/**
 * 测试登陆
 * @author Administrator
 *
 */
public class TestLogin extends BaseTest {
	
	@Autowired
	private IStudentLoginService studentLoginService;

	/**
	 * 测试学生登陆
	 */
	@Test
	public void testLogin() throws Exception {
		Student student = studentLoginService.login("1234", "123");
		System.out.println(JSON.toJSONString(student));
		
	}
	
	/**
	 * 测试教师登陆
	 */
	@Resource
	private ITeacherLoginService teacherLoginService;
	
	@Test
	public void testTeacherLogin() throws Exception{
		
		Teacher teacher = teacherLoginService.login("libaibai", "baibaili");
		System.out.println(JSON.toJSONString(teacher));
		
	}
	
	/**
	 * 测试管理员登陆
	 */
	@Resource
	private IManagerLoginService managerLoginService;
	
	@Test
	public void testManagerLogin() throws Exception{
		
		Manager manager = managerLoginService.login("123", "123");
		System.out.println(JSON.toJSONString(manager));
		
	}

}
