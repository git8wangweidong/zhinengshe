package com.zhinengshe.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	/**
	 * 跳转教师登陆
	 * @return
	 */
	@RequestMapping(value = "/teacherLogin")
	public String teacherLogin(){
		return "back/login/login-teacher";
	}
	
	/**
	 * 跳转学生登陆
	 * @return
	 */
	@RequestMapping(value = "/studentLogin")
	public String sudentLogin(){
		return "front/login/login-student";
	}
	
	/**
	 * 跳转管理员登陆
	 * @return
	 */
	@RequestMapping(value = "/managerLogin")
	public String managerLogin(){
		return "back/login/login-manager";
	}
	

}
