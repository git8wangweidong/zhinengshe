package com.zhinengshe.controller.questiontype;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.pojo.questiontype.Questiontype;
import com.zhinengshe.service.questiontype.IQuestionTypeService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Controller
@RequestMapping("questionType")
public class QuestionTypeController extends BaseController{
	
	@Resource
	private IQuestionTypeService questionTypeService;

	/**
	 * toAdd
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd() {
		return "back/question/add-questiontype";
	}

	/**
	 * 添加
	 * @param questiontype
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Questiontype questiontype, Model model) {

		Boolean b = null;
		try {
			b = questionTypeService.add(questiontype);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			return this.list(null, null, model);
		}
		model.addAttribute("questiontype", questiontype);
		return "back/question/add-questiontype";
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
			b = questionTypeService.del(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			return this.list(null, null, model);
		}
		model.addAttribute("del_msg", "删除失败，请稍后重试");
		return "back/question/add-questiontype";

	}

	/**
	 * 修改-编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model) {

		Questiontype questiontype = null;
		try {
			questiontype = questionTypeService.get(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (questiontype != null) {
			model.addAttribute("questiontype", questiontype);
			return "back/question/edit-questiontype";
		}
		model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		return "back/question/edit-questiontype";

	}

	/**
	 * 修改-更新
	 * @param questiontype
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Questiontype Questiontype, Model model) {

		Boolean b = null;
		try {
			b = questionTypeService.update(Questiontype);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			model.addAttribute("update_msg", "更新成功");
			return this.list(null, null, model);
		}
		model.addAttribute("Questiontype", Questiontype);
		model.addAttribute("update_msg", "更新失败");

		return "questiontype-edit";

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
			pagination = questionTypeService.list(name, pageNo);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		model.addAttribute("pagination", pagination);
		return "back/question/add-questiontype";

	}

}
