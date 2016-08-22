package com.zhinengshe.pojo.questionnaire;

import java.util.List;

import com.zhinengshe.pojo.question.Question;

public class QuestionList {
	

	private List<Question> questions;

	
	public QuestionList() {
		super();
	}

	public QuestionList(List<Question> questions) {
		super();
		this.questions = questions;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
