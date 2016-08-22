package com.zhinengshe.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.questionnaire.QuestionList;
import com.zhinengshe.pojo.questionnaire.Questionnaire;
import com.zhinengshe.service.questionnaire.IQuestionnaireService;
import com.zhinengshe.test.basetest.BaseTest;

public class NaireTest extends BaseTest {

	
	@Autowired
	private IQuestionnaireService questionnaireService;
	
	@Test
	public void testAdd(){
		
		Questionnaire naire = new Questionnaire();
		naire.setName("问卷一号");
		
		QuestionList questions = new QuestionList();
		
		List<Question> list = new ArrayList<>();
		
		Question q1 = new Question();
		q1.setId(1);
		
		Question q2 = new Question();
		q2.setId(2);
		
		Question q3 = new Question();
		q3.setId(3);
		
		list.add(q1);
		
		list.add(q2);
		
		list.add(q3);
		
		questions.setQuestions(list);
		
		Boolean b = questionnaireService.add(naire, questions);
		
		System.out.println(b);
	}
}
