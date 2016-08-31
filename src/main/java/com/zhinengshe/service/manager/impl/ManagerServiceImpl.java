package com.zhinengshe.service.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.manager.ManagerMapper;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.manager.ManagerExample;
import com.zhinengshe.pojo.manager.ManagerExample.Criteria;
import com.zhinengshe.pojo.teacher.Teacher;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.manager.IManagerService;
import com.zhinengshe.utlis.pagenation.Pagination;

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

	@Override
	public Pagination list(String name, Byte category, String username, String tel, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagination list(Manager manager) {
		return null;
		
	}

	

}
