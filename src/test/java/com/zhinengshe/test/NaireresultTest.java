package com.zhinengshe.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.zhinengshe.pojo.naireresult.AnswerDistribution;
import com.zhinengshe.pojo.naireresult.Naireresult;
import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.service.naireresult.INaireresultService;
import com.zhinengshe.test.basetest.BaseTest;

public class NaireresultTest extends BaseTest {

	
	@Autowired
	private INaireresultService naireresultServcie;
	
	@Test
	public void testCommit() throws Exception{
		
		Question q = new Question();
		q.setId(1);
		q.setAnswer("sssss");
		
		Question q1 = new Question();
		q1.setId(3);
		q1.setAnswer("sssss");
		
		Question q2 = new Question();
		q2.setId(2);
		q2.setAnswer("sssss");
		
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setId(1);
		questionnaire.setPeriods("第一期");
		questionnaire.setStudentId(19);
		
		List<Question> list = new ArrayList<>();
		list.add(q);
		list.add(q1);
		list.add(q2);
		
		QuestionList questionList = new QuestionList();
		questionList.setQuestions(list);
		
		Boolean b = naireresultServcie.commitNaire(questionList, questionnaire);
		
		System.out.println(b);
		
	}
	
	@Test
	public void testSql() throws Exception{
		List<AnswerDistribution> list = naireresultServcie.testSql(1,1);
		
		for (AnswerDistribution result : list) {
			System.out.println(JSONObject.toJSONString(result));
		}
	}
	
	@Test
	public void testShowNaire() throws Exception{
		List<Naireresult> list = naireresultServcie.showNaire(1, 1);
		
		for (Naireresult naireresult : list) {
			System.out.println(JSONObject.toJSONString(naireresult));
		}
		
	}
	
	
}
