package com.zhinengshe.controller.questionnaire;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhinengshe.controller.BaseController;
import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.pojo.questiontype.Questiontype;
import com.zhinengshe.service.naireresult.INaireresultService;
import com.zhinengshe.service.questionnaire.IQuestionnaireService;
import com.zhinengshe.service.questiontype.IQuestionTypeService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController extends BaseController{
	
	@Resource
	private IQuestionnaireService questionnaireService;
	
	@Resource
	private INaireresultService naireresultServcie;
	
	@Resource
	private IQuestionTypeService questionTypeService;
	
	/**
	 * toadd 到添加问卷页面
	 * @return
	 */
	@RequestMapping(value="/toAdd",method = RequestMethod.GET)
	public String toAdd(Model model){
		
		List<Questiontype> list = null;
		try {
			list = questionTypeService.list();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		model.addAttribute("questiontypes", list);
		
		return "back/questionnaire/add-naire";
		
	}
	
	/**
	 * add 添加问卷
	 * @return
	 */
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add(Questionnaire t, QuestionList questionList, Model model){
		
		Boolean b = null;
		try {
			b = questionnaireService.addNaire(t, questionList);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			model.addAttribute("add-msg", "添加成功");
			return this.list(null, null, null, null, model);
		}
		model.addAttribute("add-msg", "添加失败");
		model.addAttribute("questionnaire", t);
		model.addAttribute("questionList", questionList);
		return "back/questionnaire/add-naire";
		
		
	}
	
	/**
	 * showState问卷完成状态展示
	 * @return
	 */
	@RequestMapping(value="/showState",method = RequestMethod.GET)
	public String showState(){
		
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
		
		Questionnaire naire = null;
		try {
			naire = questionnaireService.get(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
		model.addAttribute("naire",naire);
		
		return "front/question-naire/index-student";
		
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
		
		Boolean b = null;
		try {
			b = naireresultServcie.commitNaire(questionList, questionnaire);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (b) {
			return "success/commit-success"; // 完成问卷页面
		}
		return "success/commit-failed"; // 完成问卷失败
		
	}
	
	/**
	 * 分页展示问卷列表
	 * @param name
	 * @param periods
	 * @param nairtype
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(String name, String periods, Integer nairtype, Integer pageNo, Model model){
		
		Pagination pagination = null;
		try {
			pagination = questionnaireService.list(name, periods, nairtype, pageNo);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
		model.addAttribute("pagination",pagination);
		
		return "back/questionnaire/list-naire";
		
	}
	
}
