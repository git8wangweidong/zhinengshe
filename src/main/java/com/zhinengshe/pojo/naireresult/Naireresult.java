package com.zhinengshe.pojo.naireresult;

public class Naireresult {
    private Integer id;

    private Integer questionid;

    private Integer questiontype;

    private String answer;

    private Integer naireid;

    private String periods;

    private Integer commiter;
    
    private AnswerDistribution answerDistribution;
    
    public AnswerDistribution getAnswerDistribution() {
		return answerDistribution;
	}

	public void setAnswerDistribution(AnswerDistribution answerDistribution) {
		this.answerDistribution = answerDistribution;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(Integer questiontype) {
        this.questiontype = questiontype;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getNaireid() {
        return naireid;
    }

    public void setNaireid(Integer naireid) {
        this.naireid = naireid;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods == null ? null : periods.trim();
    }

    public Integer getCommiter() {
        return commiter;
    }

    public void setCommiter(Integer commiter) {
        this.commiter = commiter;
    }
}