package com.icss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icss.bean.TabRoute;
import com.icss.bean.vo.TabRouteVo;
import com.icss.mapper.TabRouteImgMapper;
import com.icss.mapper.TabRouteMapper;
import com.icss.mapper.TabSellerMapper;
import com.icss.service.TabRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TabRouteServiceImpl implements TabRouteService {

    @Resource
    private TabRouteMapper tabRouteMapper;
    @Resource
    private TabRouteImgMapper tabRouteImgMapper;
    @Resource
    private TabSellerMapper tabSellerMapper;

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
    public TabRouteVo selectByPrimaryKey(Integer rid) {
        TabRoute tabRoute = tabRouteMapper.selectByPrimaryKey(rid);
        TabRouteVo tabRouteVo = new TabRouteVo();
        tabRouteVo.setTabRoute(tabRoute);
        tabRouteVo.setImgList(tabRouteImgMapper.selectImgByRid(tabRoute.getRid()));

        tabRouteVo.setTabSeller(tabSellerMapper.selectByPrimaryKey(tabRoute.getSid()));

        return tabRouteVo;
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
    public PageInfo selectByCidAndValue(int cid, int page, String value) {
        PageHelper.startPage(page, 8);
        PageInfo pageInfo = new PageInfo(tabRouteMapper.selectByCidAndValue(cid, value), 10);

        return pageInfo;
    }

}
