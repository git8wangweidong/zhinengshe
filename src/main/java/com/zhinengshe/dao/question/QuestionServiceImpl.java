package com.zhinengshe.dao.question;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.question.QuestionExample;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.question.IQuestionService;
import com.zhinengshe.service.questionnaire.IQuestionnaireService;

@Service("questionService")
public class QuestionServiceImpl extends AbstractService<Question, QuestionExample> implements IQuestionService {

	@Override
	public Boolean add(Question t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean del(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Question t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> get(Question t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> list() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
