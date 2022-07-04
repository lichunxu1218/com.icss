package com.icss.service;

import com.icss.bean.TabRoute;
public interface TabRouteService{


    int deleteByPrimaryKey(Integer rid);

    int insert(TabRoute record);

    int insertSelective(TabRoute record);

    TabRoute selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(TabRoute record);

    int updateByPrimaryKey(TabRoute record);

}
