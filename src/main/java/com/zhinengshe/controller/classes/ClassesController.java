package com.zhinengshe.controller.classes;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.pojo.classes.Classes;
import com.zhinengshe.service.classes.IClassesService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Controller
@RequestMapping("/classes")
public class ClassesController extends BaseController{

	@Resource
	private IClassesService classesService;
	
	/**
	 * toAdd
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd() {
		return "back/classes/add-classes";
	}

	/**
	 * 添加
	 * @param Classes
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Classes classes, Model model) {

		Boolean b = null;
		try {
			b = classesService.add(classes);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			return this.list(null, null, null, null, null, null, null, model);
		}
		model.addAttribute("classes", classes);
		return "back/classes/add-classes";
	}

	/**
	 * 删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Integer id, Model model) {

		Boolean b = null;
		try {
			b = classesService.del(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (b) {
			return this.list(null, null, null, null, null, null, null, model);
		}
		model.addAttribute("del_msg", "删除失败，请稍后重试");
		return "back/classes/add-classes";

	}

	/**
	 * 修改-编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model) {

		Classes classes = null;
		try {
			classes = classesService.get(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (classes != null) {
			model.addAttribute("classes", classes);
			return "back/classes/edit-classes";
		}
		model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		return "back/classes/add-classes";

	}

	/**
	 * 修改-更新
	 * @param Classes
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Classes classes, Model model) {
		Boolean b = null;
		try {
			b = classesService.update(classes);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			model.addAttribute("update_msg", "更新成功");
			return this.list(null, null, null, null, null, null, null, model);
		}
		model.addAttribute("update_msg", "更新失败");

		return "back/classes/edit-classes";

	}


	/**
	 * 分页查询
	 * @param Classes
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String name, String course, Integer totalcount, Integer pageNo, Byte state, Date starttime, Date endtime, Model model) {

		Pagination pagination = null;
		try {
			pagination = classesService.list(name, course, totalcount, pageNo, state, starttime, endtime);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// 查询条件回显
		model.addAttribute("name", name);
		
		model.addAttribute("pagination", pagination);
		return "back/classes/add-classes";
	}
	
}
