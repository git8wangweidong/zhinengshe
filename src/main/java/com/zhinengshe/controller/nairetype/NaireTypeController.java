package com.zhinengshe.controller.nairetype;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.pojo.nairetype.Nairetype;
import com.zhinengshe.service.nairetype.INaireTypeService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Controller
@RequestMapping("/ynaireType")
public class NaireTypeController extends BaseController {
	
	@Resource
	private INaireTypeService naireTypeService;

	/**
	 * toAdd
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd() {
		return "back/nairetype/add-nairetype";
	}

	/**
	 * 添加
	 * @param questiontype
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Nairetype nairetype, Model model) {

		Boolean b = null;
		try {
			b = naireTypeService.add(nairetype);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (b) {
			return this.list(null, null, model);
		}
		model.addAttribute("nairetype", nairetype);
		return "back/nairetype/add-questiontype";
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
			b = naireTypeService.del(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			return this.list(null, null, model);
		}
		model.addAttribute("del_msg", "删除失败，请稍后重试");
		return "back/nairetype/add-questiontype";

	}

	/**
	 * 修改-编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model) {

		Nairetype questiontype = null;
		try {
			questiontype = naireTypeService.get(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (questiontype != null) {
			model.addAttribute("questiontype", questiontype);
			return "back/nairetype/edit-questiontype";
		}
		model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		return "back/nairetype/edit-nairetype";

	}

	/**
	 * 修改-更新
	 * @param questiontype
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Nairetype nairetype, Model model) {

		Boolean b = null;
		try {
			b = naireTypeService.update(nairetype);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			model.addAttribute("update_msg", "更新成功");
			return this.list(null, null, model);
		}
		model.addAttribute("nairetype", nairetype);
		model.addAttribute("update_msg", "更新失败");

		return "back/nairetype/nairetype-edit";

	}

	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String name, Integer pageNo, Model model) {

		Pagination pagination = null;
		try {
			pagination = naireTypeService.list(name, pageNo);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		model.addAttribute("pagination", pagination);
		return "back/nairetype/add-nairetype";

	}

}
