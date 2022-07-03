package com.icss.service;

import com.icss.bean.TabRouteImg;
public interface TabRouteImgService{


    int deleteByPrimaryKey(Integer rgid);

    int insert(TabRouteImg record);

    int insertSelective(TabRouteImg record);

    TabRouteImg selectByPrimaryKey(Integer rgid);

    int updateByPrimaryKeySelective(TabRouteImg record);

    int updateByPrimaryKey(TabRouteImg record);

}
