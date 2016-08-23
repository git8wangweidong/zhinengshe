package com.zhinengshe.controller.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhinengshe.service.manager.IManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Resource
	private IManagerService managerService;

	/**
	 * 添加
	 * @param manager
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Manager manager, Model model) {

		if (manager != null) {
			if (manager.getName() != null && manager.getName().trim().length() > 0) {
				if (manager.getUsername() != null && manager.getUsername().trim().length() > 0) {
					if (manager.getPassword() != null && manager.getPassword().trim().length() > 0) {
						Boolean b = managerService.addManager(manager);
						if (b) {
							this.list(model);
						}
					}
				}
			}
		}
		model.addAttribute("manager", manager);
		return "manager-add";
	}
	
	*//**
	 * 删除
	 * @param id
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String del(Integer id, Model model){
		
		if (id instanceof Integer) {
			 Boolean b = managerService.delManager(id);
			 if (b) {
				 this.list(model);
			}
			 model.addAttribute("del_msg", "删除失败，请稍后重试");
		}
		return "manager-list";
		
	}
	
	*//**
	 * 修改-编辑
	 * @param id
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model){
		
		if (id instanceof Integer) {
			Manager manager = new Manager();
			manager.setId(id);
			List<Manager> list = managerService.getManager(manager);
			if (list !=null && list.size()>0) {
				Manager m = list.get(0);
				model.addAttribute("manager", m);
				return "manager-edit";
			}
			model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		}
		return "manager-list";
		
	}
	
	*//**
	 * 修改-更新
	 * @param manager
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Manager manager, Model model){
		
		if (manager !=null) {
			Boolean b = managerService.updateManager(manager);
			if (b) {
				model.addAttribute("update_msg", "更新成功");
				this.list(model);
			}
			model.addAttribute("update_msg", "更新失败");
		}
		
		return "manager-edit";
		
	}
	
	*//**
	 * 查询所有
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		List<Manager> managers = managerService.listManagers();
		model.addAttribute("managers", managers);
		return "manager-list";

	}

	*//**
	 * 查询
	 * @param manager
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(Manager manager, Model model) {

		if (manager != null) {
			List<Manager> managers = managerService.getManager(manager);
			if (manager == null || managers.size() > 0) {
				model.addAttribute("managers", managers);
			}
			model.addAttribute("msg", "呃,没有符合条件的数据。。。");
		}
		return "manager-list";
	}*/

	
}
