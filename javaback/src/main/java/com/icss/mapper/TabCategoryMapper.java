package com.icss.mapper;

import com.icss.bean.TabCategory;

import java.util.List;

public interface TabCategoryMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TabCategory record);

    int insertSelective(TabCategory record);

    TabCategory selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(TabCategory record);

    int updateByPrimaryKey(TabCategory record);

    List<TabCategory> getAll();
}