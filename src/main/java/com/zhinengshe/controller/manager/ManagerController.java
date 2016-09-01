package com.zhinengshe.controller.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.service.manager.IManagerService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Resource
	private IManagerService managerService;

	/**
	 * toAdd
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
	public String add(Manager manager, Model model) {

		Boolean b = managerService.add(manager);
		if (b) {
			return this.list(null, null, null, model);
		}
		model.addAttribute("manager", manager);
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

		if (id instanceof Integer) {
			Boolean b = managerService.del(id);
			if (b) {
				return this.list(null, null, null, model);
			}
			model.addAttribute("del_msg", "删除失败，请稍后重试");
		}
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

		Manager manager = managerService.get(id);
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
	public String update(Manager manager, Model model) {

		Boolean b = managerService.update(manager);
		if (b) {
			model.addAttribute("update_msg", "更新成功");
			return this.list(null, null, null,model);
		}
		model.addAttribute("name", manager.getName());
		model.addAttribute("username", manager.getUsername());
		model.addAttribute("update_msg", "更新失败");

		return "manager-edit";

	}

	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String name,String username,Integer pageNo, Model model) {

		Pagination pagination =  managerService.list(name, username, pageNo);
		model.addAttribute("pagination", pagination);
		return "back/user/add-manager";

	}
	


}
