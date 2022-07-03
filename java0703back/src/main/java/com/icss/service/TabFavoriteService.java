package com.icss.service;

import com.icss.bean.TabFavorite;
public interface TabFavoriteService{


    int deleteByPrimaryKey(Integer rid, Integer uid);

    int insert(TabFavorite record);

    int insertSelective(TabFavorite record);

    TabFavorite selectByPrimaryKey(Integer rid, Integer uid);

    int updateByPrimaryKeySelective(TabFavorite record);

    int updateByPrimaryKey(TabFavorite record);

}
