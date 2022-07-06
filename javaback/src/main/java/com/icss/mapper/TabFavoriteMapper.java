package com.icss.mapper;

import com.icss.bean.TabFavorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TabFavoriteMapper {
    int deleteByPrimaryKey(@Param("rid") Integer rid, @Param("uid") Integer uid);

    int insert(TabFavorite record);

    int insertSelective(TabFavorite record);

    TabFavorite selectByPrimaryKey(@Param("rid") Integer rid, @Param("uid") Integer uid);

    int updateByPrimaryKeySelective(TabFavorite record);

    int updateByPrimaryKey(TabFavorite record);
    //我的收藏
    Integer[] myfavorite(Integer uid);
}