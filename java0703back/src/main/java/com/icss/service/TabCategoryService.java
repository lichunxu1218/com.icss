package com.icss.service;

import com.icss.bean.TabCategory;
public interface TabCategoryService{


    int deleteByPrimaryKey(Integer cid);

    int insert(TabCategory record);

    int insertSelective(TabCategory record);

    TabCategory selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(TabCategory record);

    int updateByPrimaryKey(TabCategory record);

}
