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
		return "/login/login-teacher";
	}
	
	/**
	 * 跳转教师登陆
	 * @return
	 */
	@RequestMapping(value = "/studentLogin")
	public String sudentLogin(){
		return "/login/login-student";
	}
	
	/**
	 * 跳转教师登陆
	 * @return
	 */
	@RequestMapping(value = "/managerLogin")
	public String managerLogin(){
		return "/login/login-manager";
	}

}
