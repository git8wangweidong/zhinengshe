package com.zhinengshe.service.naireresult.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhinengshe.dao.naireresult.NaireresultMapper;
import com.zhinengshe.pojo.naireresult.Naireresult;
import com.zhinengshe.pojo.naireresult.NaireresultExample;
import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.service.naireresult.INaireresultServcie;

@Service("naireresultServcie")
public class NaireresultServiceImpl implements INaireresultServcie {

	@Resource
	private NaireresultMapper naireresultMapper;
	
	/**
	 * 提交问卷 问卷id 问题id 问题答案
	 */
	@Override
	public Boolean commitNaire(QuestionList questions, Questionnaire questionnaire) {
		
		 // 获取问题集合  将问题/回答 插入问卷结果表
		List<Question> list = questions.getQuestions();
		List<Naireresult> naireresults = new ArrayList<>();
		for (Question question : list) {
			Naireresult result = new Naireresult();
			result.setNaireid(questionnaire.getId());
			result.setQuestiontype(question.getQuestiontype());
			result.setQuestionid(question.getId());
			result.setAnswer(question.getAnswer());
			naireresults.add(result);
		}
		int i = naireresultMapper.isnertList(naireresults);
		return i>0;
	}

	@Override
	public List<Naireresult> showNaire(Integer naireId) {
		
		NaireresultExample example = new NaireresultExample();
		
		
		
		
		
		return null;
	}
}
