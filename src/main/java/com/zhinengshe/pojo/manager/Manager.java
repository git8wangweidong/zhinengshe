package com.zhinengshe.pojo.manager;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Manager {

	private Integer id;

	@Length(min = 2, max = 10, message = "姓名长度在2-10之间")
	private String name;

	@NotBlank(message = "用户名不能为空")
	private String username;

	@Pattern(regexp = "[0-9a-zA-Z_](6,20)", message = "密码必须是6-20个字符之间的")
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