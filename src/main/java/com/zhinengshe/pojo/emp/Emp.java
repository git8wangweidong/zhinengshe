package com.zhinengshe.pojo.emp;

import java.util.Date;
import java.util.List;

import com.zhinengshe.pojo.role.Role;

public class Emp {
    private Integer eid;

    private String ename;

    private String tel;

    private String classes;

    private Byte stustate;

    private Byte qsstate;

    private Date registtime;

    private String username;

    private String password;

    private Byte identity;
    
    private List<Role> roles;

    public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
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

    public Byte getIdentity() {
        return identity;
    }

    public void setIdentity(Byte identity) {
        this.identity = identity;
    }
}