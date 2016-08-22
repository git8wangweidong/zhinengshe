package com.zhinengshe.controller.login;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
	public String managerLogin(@Valid Manager manager, BindingResult result, Model model) {

		String username = manager.getUsername();
		String password = manager.getPassword();

		/*if (result.hasErrors()) {
			
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				model.addAttribute("ERR_"+fieldError.getField(), fieldError.getDefaultMessage());
			}
			return "login/login-manager";
			
		}*/
		if (manager != null) {
			if (username != null && username.trim().length() > 0) {
				if (password != null && password.trim().length() > 0) {

					List<Manager> list = managerLoginService.login(username, password);

					if (list.size() > 0) {
						Manager m = list.get(0);
						model.addAttribute("manager", m);

						return "index/index-manager";
					}
					model.addAttribute("error_msg", "用户名或密码不正确。。。");
				}
			}
		}
		model.addAttribute("error_msg", "用户名或密码不能为空。。。");
		return "login/login-manager";
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

		if (teacher != null) {
			if (username != null && username.trim().length() > 0) {
				if (password != null && password.trim().length() > 0) {

					List<Teacher> list = teacherLoginService.login(username, password);

					if (list.size() > 0) {
						Teacher tea = list.get(0);
						model.addAttribute("teacher", tea);

						return "index/index-teacher";
					}
					model.addAttribute("error_msg", "用户名或密码不正确。。。");
				}
			}
		}
		model.addAttribute("error_msg", "用户名或密码不能为空。。。");
		return "login/login-teacher";
	}

	/**
	 * 学生登陆
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/studentLogin", method = RequestMethod.POST)
	public String studentLogin(Student student, Model model) {

		String username = student.getUsername();
		String password = student.getPassword();

		if (student != null) {
			if (username != null && username.trim().length() > 0) {
				if (password != null && password.trim().length() > 0) {

					List<Student> list = studentLoginService.login(username, password);

					if (list.size() > 0) {
						Student stu = list.get(0);
						model.addAttribute("manager", stu);

						return "index/index-student";
					}
					model.addAttribute("error_msg", "用户名或密码不正确。。。");
				}
			}
		}
		model.addAttribute("error_msg", "用户名或密码不能为空。。。");
		return "login/login-student";
	}
}
