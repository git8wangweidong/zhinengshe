package com.zhinengshe.controller.login;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.login.IManagerLoginService;
import com.zhinengshe.service.login.IStudentLoginService;
import com.zhinengshe.service.login.ITeacherLoginService;

/**
 * 登陆控制
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Resource
	private IManagerLoginService managerLoginService;

	@Resource
	private ITeacherLoginService teacherLoginService;

	@Resource
	private IStudentLoginService studentLoginService;

	/**
	 * 管理员登陆
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/managerLogin", method = RequestMethod.POST)
	public String managerLogin(@Valid Manager manager, BindingResult result, Model model, HttpServletRequest request) {

		String username = manager.getUsername();
		String password = manager.getPassword();

		/*
		 * if (result.hasErrors()) {
		 * 
		 * List<FieldError> errors = result.getFieldErrors(); for (FieldError
		 * fieldError : errors) {
		 * model.addAttribute("ERR_"+fieldError.getField(),
		 * fieldError.getDefaultMessage()); } return "login/login-manager";
		 * 
		 * }
		 */
		List<Manager> list = managerLoginService.login(username, password);
		if (list.size() > 0) {
			Manager m = list.get(0);
			request.getSession().setAttribute("manager", m);
			model.addAttribute("manager", m);

			return "back/index/index-manager";
		}
		model.addAttribute("error_msg", "用户名或密码不能正确");
		return "back/login/login-manager";
	}

	/**
	 * 教师登陆
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/teacherLogin", method = RequestMethod.POST)
	public String teacherLogin(Teacher teacher, Model model) {

		String username = teacher.getUsername();
		String password = teacher.getPassword();

		List<Teacher> list = teacherLoginService.login(username, password);
		if (list.size() > 0) {
			Teacher tea = list.get(0);
			model.addAttribute("teacher", tea);

			return "back/index/index-teacher";
		}
		model.addAttribute("error_msg", "用户名或密码不能为空。。。");
		return "back/login/login-teacher";
	}

	/**
	 * 学生登陆
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/studentLogin", method = RequestMethod.POST)
	public String studentLogin(Student student, Model model, HttpServletRequest request) {

		String username = student.getUsername();
		String password = student.getPassword();

		List<Student> list = studentLoginService.login(username, password);
		if (list.size() > 0) {
			Student stu = list.get(0);
			request.getSession().setAttribute("student", stu);
			model.addAttribute("student", stu);

			return "front/question-naire/index-student";
		}
		model.addAttribute("error_msg", "用户名或密码不能为空。。。");
		return "login/login-student";
	}
}
