package com.zhinengshe.pojo.student;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Student implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6402527988527543080L;

	private Integer id;

    @NotBlank(message="姓名不能为空")
    private String name;
    
    @Pattern(regexp = "^1[3|4|5|7|8]\\d{9}$", message = "电话号码格式不正确")
    private String tel;
    
    @NotNull(message="班级不能为空")
    private String classes;

    @NotNull(message="班级状态不能为空")
    private Byte stustate;

    @NotNull(message="是否完成状态不能为空")
    private Byte qsstate;

    @NotNull(message="注册不能为空")
    private Date registtime;

    @NotBlank(message="用户名不能为空")
    private String username;

    @Pattern(regexp = "^[0-9_a-zA-Z]{6,20}$", message = "密码必须是6-20个字符之间的")
    private String password;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public Byte getStustate() {
        return stustate;
    }

    public void setStustate(Byte stustate) {
        this.stustate = stustate;
    }

    public Byte getQsstate() {
        return qsstate;
    }

    public void setQsstate(Byte qsstate) {
        this.qsstate = qsstate;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}