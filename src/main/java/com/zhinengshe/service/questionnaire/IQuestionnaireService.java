package com.zhinengshe.service.questionnaire;

import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.pojo.questionnaire.QuestionnaireExample;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

public interface IQuestionnaireService extends IBaseService<Questionnaire, QuestionnaireExample>{
	
	/**
	 * 添加问卷
	 * @param 问卷
	 * @param 问题集合
	 * @return boolean 是否成功
	 */
	 Boolean addNaire(Questionnaire t, QuestionList questionList);
	 
	 /**
	  * 分页展示问卷列表
	  * @param name
	  * @param nairtype
	  * @param periods
	  * @return 分页结果
	  */
	 Pagination list(String name, String periods, Integer nairtype, Integer pageNo);

}
