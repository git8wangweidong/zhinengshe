package com.zhinengshe.service.manager;

import java.util.List;

import com.zhinengshe.pojo.manager.Manager;
import com.zhinengshe.pojo.manager.ManagerExample;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

/**
 * 管理员操作
 * @author Administrator
 *
 */
public interface IManagerService extends IBaseService<Manager, ManagerExample>{

	Pagination list(Manager manager);
	
}
