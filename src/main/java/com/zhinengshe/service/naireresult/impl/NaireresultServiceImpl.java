package com.zhinengshe.service.naireresult.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhinengshe.constants.Constants;
import com.zhinengshe.dao.naireresult.NaireresultMapper;
import com.zhinengshe.dao.question.QuestionMapper;
import com.zhinengshe.dao.questionnaire.QuestionnaireMapper;
import com.zhinengshe.pojo.naireresult.AnswerDistribution;
import com.zhinengshe.pojo.naireresult.IdListAndPeriods;
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
	
	@Resource
	private QuestionnaireMapper naireMapper;
	
	@Resource
	private QuestionMapper questionMapper;
	
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
			result.setPeriods(questionnaire.getPeriods());
			result.setCommiter(questionnaire.getStudentId());
			
			naireresults.add(result);
		}
		int i = naireresultMapper.insertList(naireresults);
		return i>0;
	}

	/**
	 * 问卷结果展示
	 */
	@Override
	public List<Naireresult> showNaire(Integer naireId,Integer periods) {
		
		// 查询当前问卷的所有问题id
		Questionnaire naire = naireMapper.selectByPrimaryKey(naireId);
		String sid = naire.getQuestionid();
		
		String[] sids = sid.split("\\|");
		
		IdListAndPeriods periods4Single = new IdListAndPeriods();
		IdListAndPeriods periods4Text = new IdListAndPeriods();
		
		// 接收打分题目的姐
		List<Integer> ids = new ArrayList<>();
		// 声明接收 单行填空的集合
		List<Integer> inputIds = new ArrayList<>();
		
		for (int i = 0; i < sids.length; i++) {
			// 想不出来怎么解决 只能暂时这样浪费了
			Question question = questionMapper.selectByPrimaryKey(Integer.parseInt(sids[i]));
			Integer questiontype = question.getQuestiontype();
			if (Constants.QUESTION_SINGLE_TYPE == questiontype) {
				ids.add(Integer.parseInt(sids[i]));
			}
			if (Constants.QUESTION_INPUT_TYPE == questiontype) {
				inputIds.add(Integer.parseInt(sids[i]));
			}
			
		}
		
		periods4Single.setIdList(ids);
		periods4Single.setPeriods(periods);
		periods4Single.setQuestionids(ids);
		periods4Single.setAnswerList(Constants.ANSWER_LIST);
		
		List<AnswerDistribution> distributionList = naireresultMapper.selectAnswerDistribution(periods4Single);
		
		List<Naireresult> list = null;
		
		List<Naireresult> InputList = null;
				
		if (ids.size()>0) {
			// 查询平均值
			list = naireresultMapper.selectAvgByIdListAndPeriods(periods4Single);
			// 对比问题ID 将答案分布结果添加到结果展示对象中去
			for (Naireresult naireresult : list) {
				Integer questionid = naireresult.getQuestionid();
				for (AnswerDistribution distribution : distributionList) {
					if (questionid == distribution.getQuestionId()) {
						naireresult.setAnswerDistribution(distribution);
					}
				}
			}
			
		}
		
		periods4Text.setIdList(inputIds);
		periods4Text.setPeriods(periods);
		
		if (inputIds.size()>0) {
			// 查询问答结果
			InputList = naireresultMapper.selectTextByIdListAndPeriods(periods4Text);
		}
		if (list!=null && list.size()>0) {
			if (InputList!=null && InputList.size()>0) {
				list.addAll(InputList);
			}
		}
		return list;
		
	}
	
	/**
	 * 查询答案分布
	 * @param naireId
	 * @return
	 */
	public List<AnswerDistribution> testSql(Integer naireId,Integer periods){
		
		IdListAndPeriods idListAndPeriods = new IdListAndPeriods();
		
		idListAndPeriods.setPeriods(periods);
		
		
		
		List<Integer> questionids = new ArrayList<>();
		questionids.add(1);
		questionids.add(2);
		questionids.add(3);
		questionids.add(13);
		questionids.add(14);
		questionids.add(15);
		questionids.add(16);
		questionids.add(17);
		
		
		List<Integer> answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);
		answerList.add(4);
		
		idListAndPeriods.setQuestionids(questionids);
		idListAndPeriods.setAnswerList(Constants.ANSWER_LIST);
		
		List<AnswerDistribution> list = naireresultMapper.selectAnswerDistribution(idListAndPeriods);
		
		return list;
		
	}
	
}
