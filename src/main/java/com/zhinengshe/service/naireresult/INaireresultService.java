package com.zhinengshe.service.naireresult;

import java.util.List;

import com.zhinengshe.pojo.naireresult.AnswerDistribution;
import com.zhinengshe.pojo.naireresult.Naireresult;
import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;

public interface INaireresultService {
	
	/**
	 * 提交问卷
	 * @param questionId 问题id
	 * @param answer 问题回答
	 * @param naireId 问卷Id
	 * @return 添加是否成功
	 */
	Boolean commitNaire(QuestionList questions, Questionnaire questionnaire)throws Exception;

	/**
	 * 满意度调查展示
	 * @param naireId
	 * @return List<Naireresult>  处理后的问卷结果
	 */
	List<Naireresult> showNaire(Integer naireId,Integer periods)throws Exception;
	
	/**
	 * sql 测试
	 * @param naireId
	 * @return
	 */
	List<AnswerDistribution> testSql(Integer naireId,Integer periods)throws Exception;

}
