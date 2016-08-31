package com.zhinengshe.pojo.question;

import java.io.Serializable;

public class Question implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3791527761693949L;

	private Integer id;

    private String question;

    private String answer;

    private Integer questiontype;
    
private Integer startRow; // 起始页
    
    private Integer pageNo;  // 当前页
    
    private Integer pageSize = 5;  // 每页默认条数  

    public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.startRow = (pageNo-1) * pageSize; // 页码发生改变 重新计算起始页
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.startRow = (pageNo-1) * pageSize; // 每页数发生改变 重新计算起始页
		this.pageSize = pageSize;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(Integer questiontype) {
        this.questiontype = questiontype;
    }
}