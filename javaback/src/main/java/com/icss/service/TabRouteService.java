package com.icss.service;

import com.github.pagehelper.PageInfo;
import com.icss.bean.TabRoute;

import java.util.List;

public interface TabRouteService{


    int deleteByPrimaryKey(Integer rid);

    int insert(TabRoute record);

    int insertSelective(TabRoute record);

    TabRoute selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(TabRoute record);

    int updateByPrimaryKey(TabRoute record);

    PageInfo selectByCid(int cid, int page);

    PageInfo selectByCidAndValue(int cid, int page ,String value);
}
