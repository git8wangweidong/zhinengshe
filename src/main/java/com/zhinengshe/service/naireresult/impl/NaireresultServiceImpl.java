package com.zhinengshe.service.naireresult.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhinengshe.dao.naireresult.NaireresultMapper;
import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.service.naireresult.INaireresultServcie;
import com.zhinengshe.service.question.IQuestionService;

@Service("naireresultServcie")
public class NaireresultServiceImpl implements INaireresultServcie {

	@Resource
	private NaireresultMapper naireresultMapper;
	
	@Resource
	private IQuestionService questionService;
	
	
	public Boolean finish(QuestionList questionList, Questionnaire questionnaire){
		
		
		return null;
		
	}
}
