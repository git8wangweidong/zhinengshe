package com.zhinengshe.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	/**
	 * 跳转教师登陆
	 * @return
	 */
	@RequestMapping("/teacherLogin")
	public String teacherLogin(){
		return "/login/login-teacher";
	}
	
	/**
	 * 跳转教师登陆
	 * @return
	 */
	@RequestMapping("/studentLogin")
	public String sudentLogin(){
		return "/login/login-student";
	}
	
	/**
	 * 跳转教师登陆
	 * @return
	 */
	@RequestMapping("/managerLogin")
	public String managerLogin(){
		return "/login/login-manager";
	}

}
