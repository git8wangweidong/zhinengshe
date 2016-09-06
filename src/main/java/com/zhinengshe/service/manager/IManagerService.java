package com.zhinengshe.service.manager;

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

	/**
	 * 分页展示信息
	 * @param name 姓名
	 * @param username 用户名
	 * @param pageNo 当前页
	 * @return
	 */
	Pagination list(String name, String username, Integer pageNo)throws Exception;
	
}
