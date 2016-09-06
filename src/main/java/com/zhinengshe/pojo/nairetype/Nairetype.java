package com.zhinengshe.pojo.nairetype;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class Nairetype implements Serializable{

	private static final long serialVersionUID = 8163961865728015092L;

	private Integer id;
	
	@NotBlank(message="课程不能为空")
    private String typename;

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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}