package com.zhinengshe.controller.manager;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.service.manager.IManagerService;
import com.zhinengshe.utlis.pagenation.Pagination;
import com.zhinengshe.utlis.validate.Hibernate_Validator;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {

	
	@Resource
	private IManagerService managerService;

	/**
	 * toAdd
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd() {
		return "back/user/add-manager";
	}

	/**
	 * 添加
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Manager manager, BindingResult result, Model model) {

		if (Hibernate_Validator.checkParam(model, result)) {

			model.addAttribute("manager", manager);
			return "back/user/add-manager";
		}

		Boolean b = null;
		try {
			b = managerService.add(manager);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (b) {
			return this.list(null, null, null, model);
		}
		return "back/user/add-manager";
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
			b = managerService.del(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (b) {
			return this.list(null, null, null, model);
		}
		model.addAttribute("del_msg", "删除失败，请稍后重试");
		return "back/user/add-manager";

	}

	/**
	 * 修改-编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model) {

		Manager manager = null;
		try {
			manager = managerService.get(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (manager != null) {
			model.addAttribute("manager", manager);
			return "back/user/edit-manager";
		}
		model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		return "back/user/edit-manager";

	}

	/**
	 * 修改-更新
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid Manager manager, BindingResult result, Model model) {

		if (Hibernate_Validator.checkParam(model, result)) {

			model.addAttribute("update_msg", "更新失败");
			model.addAttribute("manager", manager);
			return "back/user/edit-manager";
		}

		Boolean b = null;
		try {
			b = managerService.update(manager);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			model.addAttribute("update_msg", "更新成功");
			return this.list(null, null, null, model);
		}
		return "back/user/edit-manager";

	}

	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String name, String username, Integer pageNo, Model model) {

		Pagination pagination = null;
		try {
			pagination = managerService.list(name, username, pageNo);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		model.addAttribute("pagination", pagination);
		return "back/user/add-manager";

	}

}
