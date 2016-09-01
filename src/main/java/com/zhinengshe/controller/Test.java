package com.zhinengshe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.teacher.ITeacherService;

@Controller
@RequestMapping("/test")
public class Test {

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
