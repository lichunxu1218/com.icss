package com.icss.service;

import com.icss.bean.TabUser;
public interface TabUserService{


    int deleteByPrimaryKey(Integer uid);

    int insert(TabUser record);

    int insertSelective(TabUser record);

    TabUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(TabUser record);

    int updateByPrimaryKey(TabUser record);

    TabUser selectByUserName(String username);

    TabUser loginUser(TabUser tabUser);
}
