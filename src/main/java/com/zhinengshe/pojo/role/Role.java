package com.zhinengshe.pojo.role;

import java.io.Serializable;
import java.util.List;

import com.zhinengshe.pojo.menu.Menu;

public class Role implements Serializable{
	
	private static final long serialVersionUID = -8736759625884904763L;

	private Integer id;

    private String name;
    
    private List<Menu> menus;
    
    public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
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
}