package com.icss.service;

import com.github.pagehelper.PageInfo;
import com.icss.bean.TabRoute;
import com.icss.bean.vo.TabRouteVo;

import java.util.List;

public interface TabRouteService{


    int deleteByPrimaryKey(Integer rid);

    int insert(TabRoute record);

    int insertSelective(TabRoute record);

    TabRouteVo selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(TabRoute record);

    int updateByPrimaryKey(TabRoute record);

    PageInfo selectByCidAndValue(Integer cid, Integer page ,String value);

}
