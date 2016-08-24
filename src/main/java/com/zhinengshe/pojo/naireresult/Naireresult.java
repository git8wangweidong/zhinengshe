package com.zhinengshe.pojo.naireresult;

public class Naireresult {
    private Integer id;

    private Integer questionid;

    private Integer questiontype;

    private String answer;

    private Integer naireid;

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
}