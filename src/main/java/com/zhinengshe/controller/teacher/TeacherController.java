package com.zhinengshe.controller.teacher;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.teacher.ITeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Resource
	private ITeacherService teacherService;

	/**
	 * 添加
	 * @param teacher
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Teacher teacher, Model model) {

		if (teacher != null) {
			if (teacher.getName() != null && teacher.getName().trim().length() > 0) {
				if (teacher.getUsername() != null && teacher.getUsername().trim().length() > 0) {
					if (teacher.getPassword() != null && teacher.getPassword().trim().length() > 0) {
						Boolean b = teacherService.add(teacher);
						if (b) {
							this.list(model);
						}
					}
				}
			}
		}
		model.addAttribute("teacher", teacher);
		return "teacher-add";
	}
	
	/**
	 * 删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Integer id, Model model){
		
		if (id instanceof Integer) {
			 Boolean b = teacherService.del(id);
			 if (b) {
				 this.list(model);
			}
			 model.addAttribute("del_msg", "删除失败，请稍后重试");
		}
		return "teacher-list";
		
	}
	
	/**
	 * 修改-编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model){
		
		if (id instanceof Integer) {
			Teacher teacher = new Teacher();
			teacher.setId(id);
			List<Teacher> list = teacherService.get(teacher);
			if (list !=null && list.size()>0) {
				Teacher m = list.get(0);
				model.addAttribute("teacher", m);
				return "teacher-edit";
			}
			model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		}
		return "teacher-list";
		
	}
	
	/**
	 * 修改-更新
	 * @param teacher
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Teacher teacher, Model model){
		
		if (teacher !=null) {
			Boolean b = teacherService.update(teacher);
			if (b) {
				model.addAttribute("update_msg", "更新成功");
				this.list(model);
			}
			model.addAttribute("update_msg", "更新失败");
		}
		
		return "teacher-edit";
		
	}
	
	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		List<Teacher> teachers = teacherService.list();
		model.addAttribute("teachers", teachers);
		return "teacher-list";

	}

	/**
	 * 查询
	 * @param teacher
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(Teacher teacher, Model model) {

		if (teacher != null) {
			List<Teacher> teachers = teacherService.get(teacher);
			if (teacher == null || teachers.size() > 0) {
				model.addAttribute("teachers", teachers);
			}
			model.addAttribute("msg", "呃,没有符合条件的数据。。。");
		}
		return "teacher-list";
	}
}
