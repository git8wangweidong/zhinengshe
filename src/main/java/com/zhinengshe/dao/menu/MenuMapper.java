package com.zhinengshe.dao.menu;

import com.zhinengshe.dao.basedao.IBaseMapper;
import com.zhinengshe.pojo.menu.Menu;
import com.zhinengshe.pojo.menu.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuMapper extends IBaseMapper<Menu, MenuExample>{
	
	List<Menu> selectMenuList();
	
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);
}