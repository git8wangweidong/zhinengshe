package com.zhinengshe.controller.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.manager.ManagerExample;
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
			return this.list(model);
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
				return this.list(model);
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

		Manager manager = new Manager();
		manager.setId(id);
		List<Manager> list = managerService.get(manager);
		if (list != null && list.size() > 0) {
			Manager m = list.get(0);
			model.addAttribute("manager", m);
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
			return this.list(model);
		}
		model.addAttribute("update_msg", "更新失败");

		return "manager-edit";

	}

	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		Manager manager = new Manager();
		Pagination pagination =  managerService.list(manager);
		model.addAttribute("pagination", pagination);
		return "back/user/add-manager";

	}
	
	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listByPage", method = RequestMethod.GET)
	public String listByPage(String name, String username, Integer pageNo,Model model) {

		Manager manager = new Manager();
		manager.setName(name);
		manager.setUsername(username);
		Pagination pagination = managerService.list(manager);
		
		model.addAttribute("username",username);
		model.addAttribute("name", name);
		
		model.addAttribute("pagination", pagination);
		
		
		return "back/user/add-manager";

	}

	/**
	 * 查询
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(Manager manager, Model model) {

		List<Manager> managers = managerService.get(manager);
		if (manager == null || managers.size() > 0) {
			model.addAttribute("managers", managers);
		}
		model.addAttribute("msg", "呃,没有符合条件的数据。。。");
		return "back/user/add-manager";
	}

}
