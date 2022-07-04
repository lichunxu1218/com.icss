package com.icss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icss.bean.TabRoute;
import com.icss.mapper.TabRouteMapper;
import com.icss.service.TabRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public PageInfo selectByCid(int cid, int page) {

        PageHelper.startPage(page,8);
        PageInfo pageInfo = new PageInfo(tabRouteMapper.selectByCid(cid));

        return pageInfo;
    }

}
