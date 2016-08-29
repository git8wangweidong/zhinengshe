package com.zhinengshe.service.baseservice.impl;

import java.io.Serializable;
import java.util.List;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.service.baseservice.IBaseService;

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
	 * 查询列表
	 */
	@Override
	public List<T> list(K example) {
		List<T> list = baseMapper.selectByExample(example);
		
		return list;
	}
	

}
