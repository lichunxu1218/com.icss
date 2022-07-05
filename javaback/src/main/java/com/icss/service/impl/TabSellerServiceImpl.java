package com.icss.service.impl;

import com.icss.bean.TabSeller;
import com.icss.mapper.TabSellerMapper;
import com.icss.service.TabSellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TabSellerServiceImpl implements TabSellerService{

    @Resource
    private TabSellerMapper tabSellerMapper;

    @Override
    public int deleteByPrimaryKey(Integer sid) {
        return tabSellerMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int insert(TabSeller record) {
        return tabSellerMapper.insert(record);
    }

    @Override
    public int insertSelective(TabSeller record) {
        return tabSellerMapper.insertSelective(record);
    }

    @Override
    public TabSeller selectByPrimaryKey(Integer sid) {
        return tabSellerMapper.selectByPrimaryKey(sid);
    }

    @Override
    public int updateByPrimaryKeySelective(TabSeller record) {
        return tabSellerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TabSeller record) {
        return tabSellerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TabSeller> selectSellerBySid(int sid) {
        return null;
    }

}
