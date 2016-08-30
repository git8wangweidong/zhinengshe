package com.zhinengshe.controller.questionnaire;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.service.naireresult.INaireresultServcie;
import com.zhinengshe.service.questionnaire.IQuestionnaireService;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	
	@Resource
	private IQuestionnaireService service;
	
	@Resource
	private INaireresultServcie naireresultServcie;
	
	
	/**
	 * add 添加问卷
	 * @return
	 */
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(){
		return "back/questionnaire/add-naire";
		
	}
	
	/**
	 * toPublish 添加问卷
	 * @return
	 */
	@RequestMapping(value="/toPublish",method = RequestMethod.GET)
	public String toPublish(){
		
		// TODO 展示所有的问卷 及班级
		
		return "back/questionnaire/publish-naire";
		
	}
	
	/**
	 * state 添加问卷
	 * @return
	 */
	@RequestMapping(value="/state",method = RequestMethod.GET)
	public String state(){
		
		// TODO 展示所有的问卷完成率 及已做答人数
		
		return "back/questionnaire/state-naire";
		
	}
	
	/**
	 * 问卷展示
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/show",method = RequestMethod.GET)
	public String show(Integer id,Model model){
		
		Questionnaire naire = service.get(id);
		
		model.addAttribute("naire",naire);
		
		return "index/index-student";
		
	}
	
	/**
	 * 提交问卷
	 * @param questionList 问题集合
	 * @param questionnaire 当前问卷
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/commit",method = RequestMethod.POST)
	public String commit(QuestionList questionList, Questionnaire questionnaire, Model model){
		
		Boolean b = naireresultServcie.commitNaire(questionList, questionnaire);
		if (b) {
			return "success/commit-success"; // 完成问卷页面
		}
		
		return "success/commit-failed"; // 完成问卷失败
		
	}
	
}
