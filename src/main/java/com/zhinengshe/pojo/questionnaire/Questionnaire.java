package com.zhinengshe.pojo.questionnaire;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.zhinengshe.pojo.question.Question;
import com.zhinengshe.pojo.questiontype.Questiontype;

public class Questionnaire implements Serializable {
	 
	private static final long serialVersionUID = -4990817197414713103L;

	private Integer id;
	
	@NotBlank(message="问卷名称不能为空")
	private String name;
	
	@NotBlank(message="问卷期数不能为空")
	private String periods;
	
	@NotBlank(message="问卷类型不能为空")
	private Integer nairetype;

	@NotBlank(message="问题不能为空")
	private String questionid;

	private Integer studentId;

	private Integer startRow; // 起始页

	private Integer pageNo; // 当前页

	private Integer pageSize = 5; // 每页默认条数

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
		this.startRow = (pageNo - 1) * pageSize; // 页码发生改变 重新计算起始页
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.startRow = (pageNo - 1) * pageSize; // 每页数发生改变 重新计算起始页
		this.pageSize = pageSize;
	}

	private List<Question> questions;

	private List<Questiontype> questiontypes;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

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