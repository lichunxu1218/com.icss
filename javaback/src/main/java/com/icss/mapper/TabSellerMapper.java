package com.icss.mapper;

import com.icss.bean.TabSeller;

import java.util.List;

public interface TabSellerMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(TabSeller record);

    int insertSelective(TabSeller record);

    TabSeller selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(TabSeller record);

    int updateByPrimaryKey(TabSeller record);

}