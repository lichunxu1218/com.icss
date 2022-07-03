package com.icss.service.impl;

import com.icss.bean.TabUser;
import com.icss.mapper.TabUserMapper;
import com.icss.service.TabUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TabUserServiceImpl implements TabUserService{

    @Resource
    private TabUserMapper tabUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return tabUserMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(TabUser record) {
        return tabUserMapper.insert(record);
    }

    @Override
    public int insertSelective(TabUser record) {
        return tabUserMapper.insertSelective(record);
    }

    @Override
    public TabUser selectByPrimaryKey(Integer uid) {
        return tabUserMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(TabUser record) {
        return tabUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TabUser record) {
        return tabUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public TabUser selectByUserName(String username) {
        return tabUserMapper.selectByUserName(username);
    }

    @Override
    public TabUser loginUser(TabUser tabUser) {
        return tabUserMapper.loginUser(tabUser);
    }

}
