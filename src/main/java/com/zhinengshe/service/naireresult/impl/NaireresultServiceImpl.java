package com.zhinengshe.service.naireresult.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhinengshe.constant.Constants;
import com.zhinengshe.dao.naireresult.NaireresultMapper;
import com.zhinengshe.dao.question.QuestionMapper;
import com.zhinengshe.dao.questionnaire.QuestionnaireMapper;
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
			naireresults.add(result);
		}
		int i = naireresultMapper.insertList(naireresults);
		return i>0;
	}

	/**
	 * 问卷结果展示
	 */
	@Override
	public List<Naireresult> showNaire(Integer naireId) {
		
		Questionnaire naire = naireMapper.selectByPrimaryKey(naireId);
		String sid = naire.getQuestionid();
		
		String[] sids = sid.split("\\|");
		
		List<Integer> ids = new ArrayList<>();
		for (int i = 0; i < sids.length; i++) {
			ids.add(Integer.parseInt(sids[i]));
			
		}
		NaireresultExample example = new NaireresultExample();
		example.createCriteria().andQuestionidIn(ids).andNaireidEqualTo(naireId);
		List<Naireresult> resultList = naireresultMapper.selectByExample(example);
		
		return null;
	}
	
	/**
	 * sql 测试
	 * @param naireId
	 * @return
	 */
	public List<Naireresult> testSql(Integer naireId,Integer periods){
		
		Questionnaire naire = naireMapper.selectByPrimaryKey(naireId);
		String sid = naire.getQuestionid();
		
		String[] sids = sid.split("\\|");
		
		IdListAndPeriods idListAndPeriods = new IdListAndPeriods();
		IdListAndPeriods idListAndPeriods2 = new IdListAndPeriods();
		
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
		
		idListAndPeriods.setIdList(ids);
		idListAndPeriods.setPeriods(periods);
		
		idListAndPeriods2.setIdList(inputIds);
		idListAndPeriods2.setPeriods(periods);
		
		List<Naireresult> list = null;
		
		List<Naireresult> InputList = null;
				
		if (ids.size()>0) {
			// 查询平均值
			list = naireresultMapper.selectAvgByIdListAndPeriods(idListAndPeriods);
			
		}
		if (inputIds.size()>0) {
			// 查询问答结果
			InputList = naireresultMapper.selectTextByIdListAndPeriods(idListAndPeriods2);
		}
		if (list!=null && list.size()>0) {
			if (InputList!=null && InputList.size()>0) {
				list.addAll(InputList);
			}
		}
		return list;
		
	}
	
	
}
