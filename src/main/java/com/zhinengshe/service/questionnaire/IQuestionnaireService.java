package com.zhinengshe.service.questionnaire;

import java.util.List;
import java.util.Map;

import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.pojo.questionnaire.QuestionnaireExample;
import com.zhinengshe.service.baseservice.IBaseService;

public interface IQuestionnaireService extends IBaseService<Questionnaire, QuestionnaireExample>{
	
	/**
	 * 添加问卷
	 * @param 问卷
	 * @param 问题集合
	 * @return boolean 是否成功
	 */
	public Boolean addNaire(Questionnaire t, QuestionList questionList);

	/**
	 * 删除问卷
	 * @param id
	 * @return
	 *//*
	public Boolean del(Integer id);

	*//**
	 * 更新问卷
	 * @param t
	 * @return
	 *//*
	public Boolean update(Questionnaire t);

	*//**
	 * 查询问卷
	 * @param t
	 * @return
	 *//*
	public List<Questionnaire> get(Questionnaire t);

	*//**
	 * 列表问卷
	 * @return
	 *//*
	public List<Questionnaire> list();
	
	*//**
	 * 获取问卷
	 * @param id
	 * @return
	 *//*
	public Questionnaire get(Integer id);*/
	

}
