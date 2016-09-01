package com.zhinengshe.controller.student;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.service.student.IStudentService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private IStudentService studentService;

	/**
	 * toAdd
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd() {
		return "back/user/add-student";
	}

	/**
	 * 添加
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Student student, Model model) {

		student.setRegisttime(new Date());
		Boolean b = studentService.add(student);
		if (b) {
			return this.list(null, null, null, null, null, null, null, null, model);
		}
		model.addAttribute("student", student);
		return "back/user/add-student";
	}

	/**
	 * 删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Integer id, Model model) {

		Boolean b = studentService.del(id);
		if (b) {
			return this.list(null, null, null, null, null, null, null, null, model);
		}
		model.addAttribute("del_msg", "删除失败，请稍后重试");
		return "back/user/add-student";

	}

	/**
	 * 修改-编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model) {

		Student student = studentService.get(id);
		if (student != null) {
			model.addAttribute("student", student);
			return "back/user/edit-student";
		}
		model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		return "back/user/add-student";

	}

	/**
	 * 修改-更新
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Student student, Model model) {
		student.setRegisttime(new Date());
		Boolean b = studentService.update(student);
		if (b) {
			model.addAttribute("update_msg", "更新成功");
			return this.list(null, null, null, null, null, null, null, null, model);
		}
		model.addAttribute("update_msg", "更新失败");

		return "back/user/edit-student";

	}


	/**
	 * 分页查询
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String name, String username, String classes, String tel, Integer pageNo, Byte qsstate, Byte stustate, Date registtime, Model model) {

		Pagination pagination = studentService.list(name, username, classes, tel, pageNo, qsstate, stustate, registtime);
		
		// 查询条件回显
		model.addAttribute("name", name);
		model.addAttribute("username", username);
		model.addAttribute("classes", classes);
		model.addAttribute("tel", tel);
		model.addAttribute("qsstate", qsstate);
		model.addAttribute("stustate", stustate);
		model.addAttribute("registtime", registtime);
		
		model.addAttribute("pagination", pagination);
		return "back/user/add-student";
	}

}
