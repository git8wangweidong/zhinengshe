package com.zhinengshe.service.naireresult;

import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;

public interface INaireresultServcie {
	
	/**
	 * 完成问卷
	 * @param questionList
	 * @param questionnaire
	 * @return
	 */
	public Boolean finish(QuestionList questionList, Questionnaire questionnaire);

}
