package com.zhinengshe.controller.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.pojo.student.StudentExample;
import com.zhinengshe.service.student.IStudentService;

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
	public String toAdd(){
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

		if (student != null) {
			if (student.getName() != null && student.getName().trim().length() > 0) {
				if (student.getUsername() != null && student.getUsername().trim().length() > 0) {
					if (student.getPassword() != null && student.getPassword().trim().length() > 0) {
						Boolean b = studentService.add(student);
						if (b) {
							this.list(model);
						}
					}
				}
			}
		}
		model.addAttribute("student", student);
		return "student-add";
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
			 Boolean b = studentService.del(id);
			 if (b) {
				 this.list(model);
			}
			 model.addAttribute("del_msg", "删除失败，请稍后重试");
		}
		return "student-list";
		
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
			Student student = new Student();
			student.setId(id);
			List<Student> list = studentService.get(student);
			if (list !=null && list.size()>0) {
				Student m = list.get(0);
				model.addAttribute("student", m);
				return "student-edit";
			}
			model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		}
		return "student-list";
		
	}
	
	/**
	 * 修改-更新
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Student student, Model model){
		
		if (student !=null) {
			Boolean b = studentService.update(student);
			if (b) {
				model.addAttribute("update_msg", "更新成功");
				this.list(model);
			}
			model.addAttribute("update_msg", "更新失败");
		}
		
		return "student-edit";
		
	}
	
	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		StudentExample example = new StudentExample();
		
		List<Student> students = studentService.list(example);
		model.addAttribute("students", students);
		return "student-list";

	}

	/**
	 * 查询
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(Student student, Model model) {

		if (student != null) {
			List<Student> students = studentService.get(student);
			if (student == null || students.size() > 0) {
				model.addAttribute("students", students);
			}
			model.addAttribute("msg", "呃,没有符合条件的数据。。。");
		}
		return "student-list";
	}
	
}
