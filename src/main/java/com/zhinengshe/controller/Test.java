package com.zhinengshe.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.zhinengshe.service.login.IManagerLoginService;

public class Test {

	private static Logger log = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		
		log.info("咋发生 法萨芬是否");
		log.error("发沙发沙发萨芬");
	}
	
	
	@Resource
	private IManagerLoginService loginService;
	@org.junit.Test
	public void testLog(){
		try {
			loginService.login("admin", "admin");
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*@Resource
	private ITeacherService teacherService;

	@RequestMapping("/teacher")
	public String getTeacherById(Integer id, Model model) throws Exception {

		Teacher t = new Teacher();
		t.setId(id);
		
		
		List<Teacher> teacher = teacherService.get(t);

		model.addAttribute("teacher", teacher);
		if (true) {
			throw new BusinessException("【error-info】：", "【BusinessException error】");
		}
		
		return "test";

	}*/

}
