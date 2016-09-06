package com.zhinengshe.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.service.question.IQuestionService;
import com.zhinengshe.test.basetest.BaseTest;

public class QuestionTest extends BaseTest {

	
	@Autowired
	private IQuestionService questionService;
	
	@Test
	public void testAdd() throws Exception{
		
		Question q = new Question();
		
		q.setQuestion("你是谁你是谁？");
		q.setAnswer("我不是隔壁的王大锤");
		q.setQuestiontype(1);
		
		
		Boolean b = questionService.add(q);
		
		System.out.println(b);
	}
	
	@Test
	public void testDel() throws Exception{
		Boolean flag = questionService.del(20);
		System.out.println(flag);
	}
	
}
