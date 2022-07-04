package com.icss.service.impl;

import com.icss.bean.TabRouteImg;
import com.icss.mapper.TabRouteImgMapper;
import com.icss.service.TabRouteImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TabRouteImgServiceImpl implements TabRouteImgService{

    @Resource
    private TabRouteImgMapper tabRouteImgMapper;

    @Override
    public int deleteByPrimaryKey(Integer rgid) {
        return tabRouteImgMapper.deleteByPrimaryKey(rgid);
    }

    @Override
    public int insert(TabRouteImg record) {
        return tabRouteImgMapper.insert(record);
    }

    @Override
    public int insertSelective(TabRouteImg record) {
        return tabRouteImgMapper.insertSelective(record);
    }

    @Override
    public TabRouteImg selectByPrimaryKey(Integer rgid) {
        return tabRouteImgMapper.selectByPrimaryKey(rgid);
    }

    @Override
    public int updateByPrimaryKeySelective(TabRouteImg record) {
        return tabRouteImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TabRouteImg record) {
        return tabRouteImgMapper.updateByPrimaryKey(record);
    }

}
