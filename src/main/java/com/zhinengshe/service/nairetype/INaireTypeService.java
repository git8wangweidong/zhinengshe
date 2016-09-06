package com.zhinengshe.service.nairetype;

import com.zhinengshe.pojo.nairetype.Nairetype;
import com.zhinengshe.pojo.nairetype.NairetypeExample;
import com.zhinengshe.service.baseservice.IBaseService;
import com.zhinengshe.utlis.pagenation.Pagination;

public interface INaireTypeService extends IBaseService<Nairetype, NairetypeExample> {

	/**
	 * 分页展示问卷类型
	 * @param typename
	 * @param pageNo
	 * @return
	 */
	Pagination list(String typename, Integer pageNo)throws Exception;
	
}

