package com.icss.mapper;

import com.icss.bean.TabRouteImg;

import java.util.List;

public interface TabRouteImgMapper {
    int deleteByPrimaryKey(Integer rgid);

    int insert(TabRouteImg record);

    int insertSelective(TabRouteImg record);

    TabRouteImg selectByPrimaryKey(Integer rgid);

    int updateByPrimaryKeySelective(TabRouteImg record);

    int updateByPrimaryKey(TabRouteImg record);

    List<TabRouteImg> selectImgByRid(int rid);
}