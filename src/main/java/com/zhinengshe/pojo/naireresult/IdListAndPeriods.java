package com.zhinengshe.pojo.naireresult;

import java.util.List;

public class IdListAndPeriods {

	private List<Integer> idList;
	
	private Integer periods;
	
	private List<String> answerList;
	
	private List<Integer> questionids;
	
	public List<Integer> getQuestionids() {
		return questionids;
	}

	public void setQuestionids(List<Integer> questionids) {
		this.questionids = questionids;
	}

	public List<String> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<String> answerList) {
		this.answerList = answerList;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public Integer getPeriods() {
		return periods;
	}

	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
	
	
}
