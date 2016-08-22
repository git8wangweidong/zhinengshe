package com.zhinengshe.test.login;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.zhinengshe.pojo.student.Student;
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
	
	/**
	 * 测试学生登陆
	 */
	@Autowired
	private IStudentLoginService studentLoginService;
	
	@Test
	public void testLogin(){
		
		List<Student> list = studentLoginService.login("1234", "123");
		System.out.println(JSON.toJSONString(list.get(0)));
		
	}
	
	/**
	 * 测试教师登陆
	 */
	@Resource
	private ITeacherLoginService teachetLoginService;
	
	@Test
	public void testTeacherLogin(){
		
		List<Student> list = teachetLoginService.login("123", "123");
		System.out.println(JSON.toJSONString(list.get(0)));
		
	}
	
	/**
	 * 测试管理员登陆
	 */
	@Resource
	private IManagerLoginService managerLoginService;
	
	@Test
	public void testManagerLogin(){
		
		List<Student> list = managerLoginService.login("123", "123");
		System.out.println(JSON.toJSONString(list.get(0)));
		
	}

}
