package com.zhinengshe.pojo.classes;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class Classes implements Serializable{
	
	private static final long serialVersionUID = -3212479802597416883L;
	
	private Integer id;
	
	@NotBlank(message="班级名称不能为空")
	private String name;
	
	@NotBlank(message="课程不能为空")
	private String course;
	
	@NotBlank(message="班级状态不能为空")
	private Byte state;

	@NotBlank(message="开始时间不能为空")
	private Date starttime;

	@NotBlank(message="结束不能为空")
	private Date endtime;

	@NotBlank(message="班级总人数不能为空")
	private Integer totalcount;

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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course == null ? null : course.trim();
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}
}