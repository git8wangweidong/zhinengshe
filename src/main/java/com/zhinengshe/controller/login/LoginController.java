package com.zhinengshe.controller.login;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.exception.ParameterException;
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

	private static Logger log = Logger.getLogger(LoginController.class);
	
	/**
	 * 跳转教师登陆
	 * @return
	 */
	@RequestMapping(value = "/teacher")
	public String teacherLogin(){
		return "back/login/login-teacher";
	}
	
	/**
	 * 跳转学生登陆
	 * @return
	 */
	@RequestMapping(value = "/student")
	public String sudentLogin(){
		return "front/login/login-student";
	}
	
	/**
	 * 跳转管理员登陆
	 * @return
	 */
	@RequestMapping(value = "/manager")
	public String managerLogin(){
		return "back/login/login-manager";
	}
	
	/**
	 * 提取检查参数方法
	 * @param model
	 * @param result
	 * @return
	 */
	private boolean checkParam(Model model,BindingResult result){
		
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				model.addAttribute("ERR_" + fieldError.getField(), fieldError.getDefaultMessage());
			}
			return true;
		}
		return false;
	}

	/**
	 * 管理员登陆
	 * @param manager
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/managerLogin", method = RequestMethod.POST)
	public String managerLogin(@Valid Manager manager, BindingResult result, Model model, HttpServletRequest request) {

		
		if (this.checkParam(model, result)) {
			return "back/login/login-manager";
		}
		
		List<Manager> list = null;
		try {
			list = managerLoginService.login(manager.getUsername(), manager.getPassword());
		} catch (ParameterException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (list != null && list.size() > 0) {
			Manager man = list.get(0);
			request.getSession().setAttribute("manager", man);
			model.addAttribute("manager", man);
			return "back/index/index-manager";
		}
		return "back/login/login-manager";
	}

	/**
	 * 教师登陆
	 * @param manager
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/teacherLogin", method = RequestMethod.POST)
	public String teacherLogin(@Valid Teacher teacher, BindingResult result, Model model, HttpServletRequest request) {

		/*if (this.checkParam(model, result)) {
			return "back/login/login-teacher";
		}*/

		List<Teacher> list = null;
		try {
			list = teacherLoginService.login(teacher.getUsername(),teacher.getPassword());
		} catch (ParameterException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

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
	 * @throws Exception
	 */
	@RequestMapping(value = "/studentLogin", method = RequestMethod.POST)
	public String studentLogin(@Valid Student student, BindingResult result, Model model, HttpServletRequest request) {

		if (this.checkParam(model, result)) {
			return "front/login/login-student";
		}

		List<Student> list = null;
		try {
			list = studentLoginService.login(student.getUsername(), student.getPassword());
		} catch (ParameterException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (list.size() > 0) {
			Student stu = list.get(0);
			request.getSession().setAttribute("student", stu);
			model.addAttribute("student", stu);
			return "front/question-naire/index-student";
		}
		return "front/login/login-student";
	}
}
