package com.zhinengshe.service.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.manager.ManagerMapper;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.manager.ManagerExample;
import com.zhinengshe.pojo.manager.ManagerExample.Criteria;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.manager.IManagerService;

@Service("managerService")
public class ManagerServiceImpl extends AbstractService<Manager, ManagerExample> implements IManagerService {

	@Resource
	private ManagerMapper managerMapper;

	@Autowired
	public void setMapper() {
		super.setBaseMapper(managerMapper);
	}

	/**
	 * 查询管理员
	 */
	@Override
	public List<Manager> get(Manager t) {
		ManagerExample example = new ManagerExample();
		// TODO 参数校验
		if (t != null) {
			Criteria criteria = example.createCriteria();
			if (t.getId() != null) {
				criteria.andIdEqualTo(t.getId());
			}
			if (t.getName() != null && t.getName().trim().length() > 0) {
				String name = t.getName();
				criteria.andNameLike("%" + name + "%");
			}
			if (t.getUsername() != null && t.getUsername().trim().length() > 0) {
				String username = t.getUsername();
				criteria.andUsernameLike("%" + username + "%");
			}

			List<Manager> list = this.managerMapper.selectByExample(example);
			return list;

		}
		return null;
	}

	/**
	 * 查询所有管理员
	 */
	@Override
	public List<Manager> list(ManagerExample example){
		List<Manager> list = this.managerMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 添加管理员
	 *//*
	@Override
	public Boolean add(Manager t) {
		// TODO 属性校验 -数据格式校验
		if (t != null) {
			if (t.getName() != null) {
				if (t.getUsername() != null) {
					if (t.getPassword() != null) {
						int i = this.managerMapper.insertSelective(t);
						return i > 0;
					}
				}
			}
		}
		return false;
	}
	
	*//**
	 * 删除管理员
	 *//*
	@Override
	public Boolean del(Integer id) {
		// TODO 参数校验
		if (id != null) {

			int i = this.managerMapper.deleteByPrimaryKey(id);
			return i > 0;
		}
		return false;
	}

	*//**
	 * 更新管理员
	 *//*
	@Override
	public Boolean update(Manager t) {
		// TODO 参数校验
		if (t != null) {

			int i = this.managerMapper.updateByPrimaryKeySelective(t);

			return i > 0;
		}
		return false;
	}*/

}
