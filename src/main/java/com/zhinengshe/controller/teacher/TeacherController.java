package com.zhinengshe.controller.teacher;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.teacher.ITeacherService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Resource
	private ITeacherService teacherService;
	
	
	/**
	 * toAddTeacher
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(){
		return "back/user/add-teacher";
	}

	/**
	 * 添加
	 * @param teacher
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Teacher teacher, Model model) {

		Boolean b = teacherService.add(teacher);
		if (b) {
			return this.list(model);
		}
		model.addAttribute("teacher", teacher);
		return "back/success/add-falied";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Integer id, Model model) {

		if (id instanceof Integer) {
			Boolean b = teacherService.del(id);
			if (b) {
				return this.list(model);
			}
			model.addAttribute("del_msg", "删除失败，请稍后重试");
		}
		return "teacher-list";

	}

	/**
	 * 修改-编辑
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model) {

		Teacher teacher = new Teacher();
		teacher.setId(id);
		List<Teacher> list = teacherService.get(teacher);
		if (list != null && list.size() > 0) {
			Teacher m = list.get(0);
			model.addAttribute("teacher", m);
			return "back/user/edit-teacher";
		}
		model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		return "teacher-list";

	}

	/**
	 * 修改-更新
	 * @param teacher
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Teacher teacher, Model model) {

		Boolean b = teacherService.update(teacher);
		if (b) {
			model.addAttribute("update_msg", "更新成功");
			return this.list(model);
		}

		model.addAttribute("update_msg", "更新失败");
		return "back/user/edit-teacher";

	}

	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(Model model) {
		Teacher teacher = new Teacher();
		Pagination pagination = teacherService.list(null,null, null, null, null);
		model.addAttribute("pagination", pagination);
		return "back/user/add-teacher";

	}

	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String name, Byte category, String username ,String tel, Integer pageNo, HttpServletRequest request, Model model) {
		
		Pagination pagination = teacherService.list(name,category, username, tel, pageNo);
		model.addAttribute("name", name);
		model.addAttribute("category", category);
		model.addAttribute("username", username);
		model.addAttribute("tel", tel);
		model.addAttribute("pagination", pagination);
		
		return "back/user/add-teacher";

	}
	/**
	 * 查询
	 * @param teacher
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(Teacher teacher, Model model) {

		List<Teacher> teachers = teacherService.get(teacher);
		if (teacher == null || teachers.size() > 0) {
			model.addAttribute("teachers", teachers);
		}
		
		model.addAttribute("msg", "呃,没有符合条件的数据。。。");
		return "back/user/add-teacher";
	}
}
