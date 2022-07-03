package com.icss.service.impl;

import com.icss.bean.TabRoute;
import com.icss.mapper.TabRouteMapper;
import com.icss.service.TabRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TabRouteServiceImpl implements TabRouteService{

    @Resource
    private TabRouteMapper tabRouteMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return tabRouteMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(TabRoute record) {
        return tabRouteMapper.insert(record);
    }

    @Override
    public int insertSelective(TabRoute record) {
        return tabRouteMapper.insertSelective(record);
    }

    @Override
    public TabRoute selectByPrimaryKey(Integer rid) {
        return tabRouteMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(TabRoute record) {
        return tabRouteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TabRoute record) {
        return tabRouteMapper.updateByPrimaryKey(record);
    }

}
