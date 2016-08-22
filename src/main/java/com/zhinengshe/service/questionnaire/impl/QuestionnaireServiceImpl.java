package com.zhinengshe.service.questionnaire.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.question.QuestionMapper;
import com.zhinengshe.dao.questionnaire.QuestionnaireMapper;
import com.zhinengshe.dao.questiontype.QuestiontypeMapper;
import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.question.QuestionExample;
import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.pojo.questionnaire.QuestionnaireExample;
import com.zhinengshe.pojo.questiontype.Questiontype;
import com.zhinengshe.pojo.questiontype.QuestiontypeExample;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.questionnaire.IQuestionnaireService;

@Service("questionnaireService")
public class QuestionnaireServiceImpl implements IQuestionnaireService {

	@Resource
	private QuestionnaireMapper questionnaireMapper;

	@Resource
	private QuestionMapper questionMapper;

	@Resource
	private QuestiontypeMapper questiontypeMapper;

	@Override
	public Boolean del(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Questionnaire t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questionnaire> get(Questionnaire t) {

		return null;

	}

	@Override
	public List<Questionnaire> list() {

		return null;

	}

	/**
	 * 获取问卷
	 */
	@Override
	public Questionnaire get(Integer id) {
		// 查询问卷
		Questionnaire naire = questionnaireMapper.selectByPrimaryKey(id);

		String questionid = naire.getQuestionid();
		String[] sids = questionid.split("\\|");

		List<Integer> ids = new ArrayList<>();
		for (int i = 0; i < sids.length; i++) {
			ids.add(Integer.parseInt(sids[i]));
		}

		QuestionExample example = new QuestionExample();
		example.createCriteria().andIdIn(ids);

		List<Question> questions = questionMapper.selectByExample(example);

		List<Integer> tid = new ArrayList<>();

		for (Question question : questions) {
			tid.add(question.getQuestiontype());

		}
		QuestiontypeExample questiontypeExample = new QuestiontypeExample();
		questiontypeExample.createCriteria().andIdIn(tid);
		List<Questiontype> questiontypes = questiontypeMapper.selectByExample(questiontypeExample);

		naire.setQuestions(questions);
		naire.setQuestiontypes(questiontypes);

		return naire;
	}

	/**
	 * 添加问卷
	 * 
	 * @param 问卷
	 * @param 问题集合
	 * @return boolean 是否成功
	 */
	@Override
	public Boolean add(Questionnaire t, QuestionList questionList) {
		// TODO Auto-generated method stub
		List<Question> list = questionList.getQuestions();
		Question question = list.get(0);
		Integer id = question.getId();
		
		// 遍历拼接id
		StringBuffer quetionId = new StringBuffer();

		for (int i = 0; i < list.size(); i++) {
			if (i == questionList.getQuestions().size() - 1) {
				quetionId = quetionId.append(list.get(i).getId());
			} else {
				quetionId = quetionId.append(list.get(i).getId().toString()).append("|");
			}
		}

		t.setQuestionid(quetionId.toString());
		t.setState(new Byte("1"));

		int i = questionnaireMapper.insert(t);

		return i > 0;
	}

}
