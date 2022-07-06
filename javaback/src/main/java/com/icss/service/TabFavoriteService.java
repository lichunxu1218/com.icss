package com.icss.service;

import com.github.pagehelper.PageInfo;
import com.icss.bean.TabFavorite;
import com.icss.bean.TabRoute;

import java.util.List;

public interface TabFavoriteService{


    int deleteByPrimaryKey(Integer rid, Integer uid);

    int insert(TabFavorite record);

    int insertSelective(TabFavorite record);

    TabFavorite selectByPrimaryKey(Integer rid, Integer uid);

    int updateByPrimaryKeySelective(TabFavorite record);

    int updateByPrimaryKey(TabFavorite record);
    //取消收藏的，同时修改收藏的count
    int deleteForUser(Integer rid, Integer uid, Integer rcount);

    int insertForUser(Integer rid, Integer uid, Integer rcount);
    //我的收藏 返回收藏到的线路的信息
    PageInfo myfavorite(Integer uid , Integer page);
}
