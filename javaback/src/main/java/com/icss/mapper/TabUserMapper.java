package com.icss.mapper;

import com.icss.bean.TabCategory;
import com.icss.bean.TabUser;

import java.util.List;

public interface TabUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TabUser record);

    int insertSelective(TabUser record);

    TabUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(TabUser record);

    int updateByPrimaryKey(TabUser record);

    TabUser selectByUserName(String username);

    TabUser loginUser(TabUser tabUser);


}