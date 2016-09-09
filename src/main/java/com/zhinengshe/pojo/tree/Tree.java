package com.zhinengshe.pojo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树控件对象
 * @author Administrator
 *
 */
public class Tree {

	private Integer id;  // 菜单id
	private String text; // 菜单文本
	private boolean checked; // 是否选中
	private List<Tree> children; // 下级菜单
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<Tree> getChildren() {
		if (children == null) {
			children = new ArrayList<>();
		}
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	
	
}
