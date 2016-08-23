package com.zhinengshe.pojo.student;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Student {
	
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

    @NotBlank(message="密码不能为空")
    private String password;

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