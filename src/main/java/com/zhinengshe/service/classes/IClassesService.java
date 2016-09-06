package com.zhinengshe.service.classes;

import java.util.Date;

import com.zhinengshe.pojo.classes.Classes;
import com.zhinengshe.pojo.classes.ClassesExample;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

public interface IClassesService extends IBaseService<Classes, ClassesExample> {
	
	/**
	 * 分页展示信息
	 * @param name 班级名称
	 * @param course 课程
	 * @param totalcount 总人数
	 * @param state 班级状态
	 * @param starttime 开始时间
	 * @param endtime 结束时间
	 * @return 分页信息
	 * @param pageNo 当前页
	 * @return
	 */
	
	Pagination list(String name, String course,Integer totalcount,Integer pageNo,
								Byte state, Date starttime, Date endtime)throws Exception;

}
