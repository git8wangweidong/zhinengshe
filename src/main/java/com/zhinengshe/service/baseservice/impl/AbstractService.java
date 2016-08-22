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
	

}
