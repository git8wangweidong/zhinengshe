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
	@RequestMapping(value="/receive",method = RequestMethod.POST)
	public String receive(QuestionList questionList, Questionnaire questionnaire, Model model){
		
		Boolean b = naireresultServcie.commitNaire(questionList, questionnaire);
		System.out.println(b);
		
		return null; // 完成问卷页面
		
		
		
	}
}
