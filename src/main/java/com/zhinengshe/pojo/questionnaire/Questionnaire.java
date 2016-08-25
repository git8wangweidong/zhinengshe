package com.zhinengshe.pojo.questionnaire;

import java.util.List;

import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.questiontype.Questiontype;

public class Questionnaire {
	private Integer id;

	private String name;

	private String questionid;

	private Integer nairetype;

	private String periods;
	
	private List<Question> questions;

	private List<Questiontype> questiontypes;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Questiontype> getQuestiontypes() {
		return questiontypes;
	}

	public void setQuestiontypes(List<Questiontype> questiontypes) {
		this.questiontypes = questiontypes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid == null ? null : questionid.trim();
	}

	public Integer getNairetype() {
		return nairetype;
	}

	public void setNairetype(Integer nairetype) {
		this.nairetype = nairetype;
	}

	public String getPeriods() {
		return periods;
	}

	public void setPeriods(String periods) {
		this.periods = periods == null ? null : periods.trim();
	}
}