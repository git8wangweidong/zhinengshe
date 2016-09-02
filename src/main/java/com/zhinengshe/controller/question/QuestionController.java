package com.zhinengshe.controller.question;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.service.question.IQuestionService;
import com.zhinengshe.utlis.pagenation.Pagination;

/**
 * 问题控制
 * @author Administrator
 * 存在大量bug 未修改
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Resource
	private IQuestionService questionService;
	
	/**
	 * toAdd
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd() {
		return "back/user/add-question";
	}

	/**
	 * 添加
	 * @param question
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Question question, Model model) {

		Boolean b = questionService.add(question);
		if (b) {
			return this.list(null, null, null, model);
		}
		model.addAttribute("question", question);
		return "back/user/add-question";
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
			Boolean b = questionService.del(id);
			if (b) {
				return this.list(null, null, null, model);
			}
			model.addAttribute("del_msg", "删除失败，请稍后重试");
		}
		return "back/user/add-question";

	}

	/**
	 * 修改-编辑
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer id, Model model) {

		Question question = questionService.get(id);
		if (question != null) {
			model.addAttribute("question", question);
			return "back/user/edit-question";
		}
		model.addAttribute("edit_msg", "获取详细失败，请稍后再试。");
		return "back/user/edit-question";

	}

	/**
	 * 修改-更新
	 * @param question
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Question question, Model model) {

		Boolean b = questionService.update(question);
		if (b) {
			model.addAttribute("update_msg", "更新成功");
			return this.list(null, null, null,model);
		}
		model.addAttribute("question", question);
		model.addAttribute("update_msg", "更新失败");

		return "question-edit";

	}

	/**
	 * 查询所有
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String question,Integer questiontype,Integer pageNo, Model model) {

		Pagination pagination =  questionService.list(question, questiontype, pageNo);
		model.addAttribute("pagination", pagination);
		return "back/user/add-question";

	}

}
