package com.zhinengshe.service.questionnaire.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.questionnaire.IQuestionnaireService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Service("questionnaireService")
public class QuestionnaireServiceImpl extends AbstractService<Questionnaire, QuestionnaireExample> implements IQuestionnaireService {

	@Resource
	private QuestionnaireMapper questionnaireMapper;

	@Resource
	private QuestionMapper questionMapper;

	@Resource
	private QuestiontypeMapper questiontypeMapper;
	
	@Autowired
	public void setQuestionnaireMapper() {
		super.setBaseMapper(questionnaireMapper);
	}

	/**
	 * 添加问卷
	 * @param 问卷
	 * @param 问题集合
	 * @return boolean 是否成功
	 */
	@Override
	public Boolean addNaire(Questionnaire t, QuestionList questionList) {

		List<Question> list = questionList.getQuestions();
		
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
		t.setNairetype(1);

		int i = questionnaireMapper.insert(t);

		return i > 0;
	}

	/**
	 * 展示问卷
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

	// TODO 问卷列表展示
	@Override
	public Pagination list(String name, String periods, Integer nairtype, Integer pageNo) {
		
		StringBuffer params = new StringBuffer();
		Questionnaire questionnaire = new Questionnaire();
		
		if (name != null && name.trim().length()>0) {
			params.append("name=").append(name);
			questionnaire.setName(name);
		}
		if (periods != null && periods.trim().length()>0) {
			params.append("name=").append(name);
			questionnaire.setPeriods(periods);
		}
		if (nairtype != null && nairtype.toString().trim().length()>0) {
			params.append("&nairtype=").append(nairtype);
			questionnaire.setNairetype(nairtype);
		}
		
		questionnaire.setPageNo(Pagination.cpn(pageNo));
		
		// 条件查询结果集
		List<Student> list = questionnaireMapper.selectByPage(questionnaire);
		// 条件查询记录条数
		int totalCount = questionnaireMapper.selectTotalCount(questionnaire);
		
		Pagination pagination = new Pagination(questionnaire.getPageNo(), questionnaire.getPageSize(), totalCount, list);
		
		String url = "questionnaire/list";
		pagination.pageView(url, params.toString());
		
		return pagination;
		
	}


	

}
