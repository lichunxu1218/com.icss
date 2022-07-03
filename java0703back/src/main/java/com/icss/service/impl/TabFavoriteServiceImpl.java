package com.icss.service.impl;

import com.icss.bean.TabFavorite;
import com.icss.mapper.TabFavoriteMapper;
import com.icss.service.TabFavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TabFavoriteServiceImpl implements TabFavoriteService{

    @Resource
    private TabFavoriteMapper tabFavoriteMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid,Integer uid) {
        return tabFavoriteMapper.deleteByPrimaryKey(rid,uid);
    }

    @Override
    public int insert(TabFavorite record) {
        return tabFavoriteMapper.insert(record);
    }

    @Override
    public int insertSelective(TabFavorite record) {
        return tabFavoriteMapper.insertSelective(record);
    }

    @Override
    public TabFavorite selectByPrimaryKey(Integer rid,Integer uid) {
        return tabFavoriteMapper.selectByPrimaryKey(rid,uid);
    }

    @Override
    public int updateByPrimaryKeySelective(TabFavorite record) {
        return tabFavoriteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TabFavorite record) {
        return tabFavoriteMapper.updateByPrimaryKey(record);
    }

}
