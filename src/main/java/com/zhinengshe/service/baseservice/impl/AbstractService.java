package com.zhinengshe.service.baseservice.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

public abstract class AbstractService<T, K extends Serializable> implements IBaseService<T, K> {

	private IBaseMapper<T, K> baseMapper;

	public void setBaseMapper(IBaseMapper<T, K> baseMapper) {
		this.baseMapper=baseMapper;
		
	}

	/**
	 * 添加问题
	 * @param t	
	 * @return
	 */
	@Override
	public Boolean add(T t) {

		int i = baseMapper.insert(t);
		
		return i>0;
		
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Override
	public Boolean del(Integer id) {
		
		int i = baseMapper.deleteByPrimaryKey(id);
		
		return i>0;
	}

	/**
	 * 更新
	 * @param t
	 * @return
	 */
	@Override
	public Boolean update(T t) {
		
		int i = baseMapper.updateByPrimaryKey(t);
		
		return i>0;
	}

	@Override
	public T get(Integer id) {
		return baseMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 多条件查询
	 */
	@Override
	public abstract List<T> get(T t);
	
	/**
	 * 教师列表分页
	 * @param name 姓名
	 * @param category 类别
	 * @param username 用户名
	 * @param tel 电话
	 * @param pageNo 当前页码
	 * @return 分页对象
	 */
	@Override
	public abstract Pagination list(String name, Byte category, String username ,String tel, Integer pageNo);
	
	/**
	 * 学生列表分页
	 * @param name 姓名
	 * @param username 用户名
	 * @param classes 班级
	 * @param tel 电话
	 * @param stustate 学生状态
	 * @param registTime 注册时间
	 * @param qsstate 问卷状态
	 * @param pageNo 当前页码
	 * @return 分页对象
	 */
	public Pagination list(String name, String username, String classes, String tel,Byte stustate, Date registTime,Byte qsstate, Integer pageNo) {
		return null;
	}
	

}
