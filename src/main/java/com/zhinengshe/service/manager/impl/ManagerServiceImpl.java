package com.zhinengshe.service.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhinengshe.dao.manager.ManagerMapper;
import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.manager.ManagerExample;
import com.zhinengshe.pojo.student.Student;
import com.zhinengshe.service.baseservice.impl.AbstractService;
import com.zhinengshe.service.manager.IManagerService;
import com.zhinengshe.utlis.pagenation.Pagination;

@Service("managerService")
public class ManagerServiceImpl extends AbstractService<Manager, ManagerExample> implements IManagerService {

	@Resource
	private ManagerMapper mapper;

	@Autowired
	public void setMapper() {
		super.setBaseMapper(mapper);
	}

	// TODO 管理员分页查询
	@Override
	public Pagination list(String name, String username, Integer pageNo) {
		
		StringBuffer params = new StringBuffer();
		
		Manager manager = new Manager();
		
		if (name !=null && name.trim().length()>0) {
			params.append("name=").append(name);
			manager.setName(name);
		}

		if (username !=null && username.trim().length()>0) {
			params.append("&username=").append(username);
			manager.setUsername(username);
		}
		
		manager.setPageNo(Pagination.cpn(pageNo));
		
		// 查询结果集
		List<Student> list = mapper.selectByPage(manager);
		// 查询符合条件的totalcount
		int totalCount = mapper.selectTotalCount(manager);
		
		Pagination pagination = new Pagination(manager.getPageNo(), manager.getPageSize(), totalCount, list);
		
		String url = "/manager/list";
		pagination.pageView(url, params.toString());
				
		return pagination;
	
	}


}
