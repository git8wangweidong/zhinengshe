package com.zhinengshe.pojo.questiontype;

import java.io.Serializable;

public class Questiontype implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4513151255910707149L;

	private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

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
    
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}