package com.zhinengshe.pojo.student;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
    private Integer id;

    private String name;

    private String tel;

    private String classes;

    private Byte stustate;

    private Byte qsstate;

    private Date registtime;

    private String username;

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